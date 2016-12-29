package framework;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecurityGuardian implements Filter, Serializable {

	/**
	 * <p>매소드명 : doFilter</p>
	 * <p>설명 : </p>
	 * <p>매소드 인수1 : </p>
	 * <p>매소드리턴값 : </p>
	 * <p>예외처리 : </p>
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
		FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String reqUrl = httpRequest.getRequestURI();//reqUrl
		if ((reqUrl == null) || "".equals( reqUrl.trim() )) {//요청 URL 체크
			System.out.println("요청 URL이 없습니다.");
//			writer.write( ICbcFwConstant.ERROR, "요청 URL이 없습니다.", httpResponse);
//			if (logger.isDebugEnabled()) {
//				logger.debug("doFilter(ServletRequest, ServletResponse, FilterChain) - end"); //$NON-NLS-1$
//			}
			return;
		}
		
		//요청 구분처리
		//1. 로그인 요청
		//2. 로그아웃 요청
		//3. 세션정보 갱신 요청
		//4. .do 로 요청된 업무처리 요청
		try{
			String param1 = httpRequest.getParameter("param1");
			String param2 = httpRequest.getParameter("param2");
			System.out.println("param1 : " + param1);
			System.out.println("param2 : " + param2);
			
//			if ( reqUrl.equals(resourceManager.getProperty(ICbcFwConstant.LOGIN_ACTION))) { //로그인 요청처리
//				User user = loginManager.logIn(httpRequest);//로그인 요청 처리
//				httpRequest.setAttribute(ICbcFwConstant.CUSER, user);	//TODO session에 User를 넣어놓는다.. 또 request에 넣어놓을 필요가 있는지....
//				httpRequest.setAttribute(WebLogConfigurator.CUR_PROG_NO, "");	//TODO 어디서 쓸려고 넣어놓았는지..
//				writer.write(user, httpResponse);//로그인 정상결과 처리
//			} else if (reqUrl.equals(resourceManager.getProperty(ICbcFwConstant.LOGOUT_ACTION))) { //로그아웃 요청처리
//				loginManager.logout(httpRequest);
//				writer.write(ICbcFwConstant.SUCCESS, "", httpResponse);	//에러발생이나도 로그아웃이므로 무시
//				if (logger.isDebugEnabled()) {
//					logger.debug("doFilter(ServletRequest, ServletResponse, FilterChain) - end"); //$NON-NLS-1$
//				}
//				return;
//			} else if (reqUrl.equals(resourceManager.getProperty(ICbcFwConstant.CHNG_PSWD_ACTION))){//비밀번호 변경 요청은  로그인을 안해도 된다.
//				chain.doFilter(request, response);
//			} else { 
//				loginManager.chkUserSession(httpRequest);//업무 로직 수행
//				chain.doFilter(request, response);//원요청 처리
//			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		System.out.println("doFilter(ServletRequest, ServletResponse, FilterChain) - end");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
