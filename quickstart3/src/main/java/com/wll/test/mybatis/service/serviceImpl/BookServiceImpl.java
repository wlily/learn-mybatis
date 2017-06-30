package com.wll.test.mybatis.service.serviceImpl;

import mapper.AppointmentDao;
import mapper.BookDao;
import com.wll.test.mybatis.dto.AppointExecution;
import com.wll.test.mybatis.entity.Appointment;
import com.wll.test.mybatis.entity.Book;
import com.wll.test.mybatis.enums.AppointStateEnum;
import com.wll.test.mybatis.exception.AppException;
import com.wll.test.mybatis.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wll on 17-6-29.
 */
@Service
public class BookServiceImpl implements BookService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // 注入Service依赖
    @Autowired
    private BookDao bookDao;

    @Autowired
    private AppointmentDao appointmentDao;


    @Override
    public Book getById(long bookId) {
        return bookDao.queryById(bookId);
    }

    @Override
    public List<Book> getList() {
        return bookDao.queryAll(0, 1000);
    }

    @Override
    @Transactional
    /**
     * 使用注解控制事务方法的优点： 1.开发团队达成一致约定，明确标注事务方法的编程风格
     * 2.保证事务方法的执行时间尽可能短，不要穿插其他网络操作，RPC/HTTP请求或者剥离到事务方法外部
     * 3.不是所有的方法都需要事务，如只有一条修改操作，只读操作不需要事务控制
     */
    public AppointExecution appoint(long bookId, long studentId) {
        try {
            // 减库存
            int update = bookDao.reduceNumber(bookId);
            if (update <= 0) {// 库存不足
                //return new AppointExecution(bookId, AppointStateEnum.NO_NUMBER);//错误写法
                throw new AppException("no number");
            } else {
                // 执行预约操作
                int insert = appointmentDao.insertAppointment(bookId, studentId);
                if (insert <= 0) {// 重复预约
                    throw new AppException("repeat appoint");
                } else {// 预约成功
                    Appointment appointment = appointmentDao.queryByKeyWithBook(bookId, studentId);
                    return new AppointExecution(bookId, AppointStateEnum.SUCCESS, appointment);
                }
            }
            // 要先于catch Exception异常前先catch住再抛出，不然自定义的异常也会被转换为AppointException，导致控制层无法具体识别是哪个异常
        } catch (AppException e) {
            throw e;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new AppException("appoint inner error:" + e.getMessage());
        }
    }
}
