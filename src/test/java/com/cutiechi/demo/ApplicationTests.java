package com.cutiechi.demo;

import com.cutiechi.demo.config.ApplicationContextConfig;

import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * 程序测试类
 *
 * @author Cutie Chi
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(
    classes = {
        ApplicationContextConfig.class
    }
)
public class ApplicationTests {

}
