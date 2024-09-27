package ex0926.log;

import jakarta.servlet.annotation.WebFilter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LogTest {
    // Log4j 2.x Logger
    private static final Logger log = LogManager.getLogger(LogTest.class);

    public static void main(String[] args) {
        System.out.println("*** 로그 테스트 시작");

        new LogTest().test();

        System.out.println("** log test 끝");
    }

    public void test() {
        log.trace("trace 관련 로그");
        log.debug("debug 관련 로그");
        log.info("info 관련 로그");
        log.warn("warn 관련 로그");
        log.error("error 관련 로그");
        log.fatal("fatal 관련 로그");
    }
}
