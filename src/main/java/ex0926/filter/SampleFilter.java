package ex0926.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;

@WebFilter(urlPatterns = "/*",
        initParams = {
                @WebInitParam(name = "fname", value = "a.jpg"),
                @WebInitParam(name = "saveDir", value = "C:\\Edu\\log"),
                @WebInitParam(name = "encoding", value = "UTF-8")
        })
public class SampleFilter implements Filter {

    // LogFactory를 사용한 Logger
    Log log = LogFactory.getLog(SampleFilter.class);

    public SampleFilter() {
        System.out.println("SampleFilter.SampleFilter constructor");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("SampleFilter.init");
        log.debug("초기화입니다");

        // 초기화 파라미터 가져오기
        String encoding = filterConfig.getInitParameter("encoding");
        String saveDir = filterConfig.getInitParameter("saveDir");

        log.debug("저장 디렉토리: " + saveDir + ", 인코딩: " + encoding);
    }

    @Override
    public void destroy() {
        System.out.println("SampleFilter.destroy");
        log.debug("필터가 파괴되었습니다");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        // 사전처리(공통기능)
        log.info("사전처리입니다: 클라이언트 IP - " + req.getRemoteAddr());

        // 요청이 처리될 때마다 로그 기록
        log.info("클라이언트가 접속했습니다: " + req.getRemoteAddr() + ", 요청 시간: " + System.currentTimeMillis());

        // 다음 타겟 대상 호출 (filter, servlet 또는 jsp)
        chain.doFilter(req, res);

        // 사후처리(공통기능)
        log.info("사후처리입니다");
    }
}
