

import jakarta.servlet.*;

import java.io.IOException;
import java.util.logging.LogRecord;

public class SampleFilter implements Filter {

    public SampleFilter() {
        System.out.println("SampleFilter.SampleFilter constructor");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("SampleFilter.init");
    }

    @Override
    public void destroy() {
        System.out.println("SampleFilter.destroy");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res ,FilterChain chain) throws IOException, ServletException {
        // 사전처리(공통기능)


        System.out.println("사전처입니다");
        chain.doFilter(req,res);// 다음 타겟대상 호출(filter or servlet or jsp)


        System.out.println("사후처리입니다");
        // 사후처리(공통기능)


    }
}
