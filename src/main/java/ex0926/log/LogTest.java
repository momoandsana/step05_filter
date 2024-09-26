package ex0926.log;

import org.apache.log4j.Logger;

public class LogTest {
    // log4j 1.x에서는 LogManager 대신 Logger.getLogger를 사용해야 합니다.
    Logger log = Logger.getLogger(LogTest.class);

    public static void main(String[] args) {
        System.out.println("*** 로그 테스트 시작");

        new LogTest().test();

        System.out.println("** log test 끝");
    }

    public void test() {
        log.trace("trace 관련 로그");  // log4j 1.x에서는 trace를 지원하지 않음
        log.debug("debug 관련 로그");
        log.info("info 관련 로그");
        log.warn("warn 관련 로그");
        log.error("error 관련 로그");
        log.fatal("fatal 관련 로그");
    }
}
