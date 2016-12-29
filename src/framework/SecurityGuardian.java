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
	 * <p>�żҵ�� : doFilter</p>
	 * <p>���� : </p>
	 * <p>�żҵ� �μ�1 : </p>
	 * <p>�żҵ帮�ϰ� : </p>
	 * <p>����ó�� : </p>
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
		FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String reqUrl = httpRequest.getRequestURI();//reqUrl
		if ((reqUrl == null) || "".equals( reqUrl.trim() )) {//��û URL üũ
			System.out.println("��û URL�� �����ϴ�.");
//			writer.write( ICbcFwConstant.ERROR, "��û URL�� �����ϴ�.", httpResponse);
//			if (logger.isDebugEnabled()) {
//				logger.debug("doFilter(ServletRequest, ServletResponse, FilterChain) - end"); //$NON-NLS-1$
//			}
			return;
		}
		
		//��û ����ó��
		//1. �α��� ��û
		//2. �α׾ƿ� ��û
		//3. �������� ���� ��û
		//4. .do �� ��û�� ����ó�� ��û
		try{
			String param1 = httpRequest.getParameter("param1");
			String param2 = httpRequest.getParameter("param2");
			System.out.println("param1 : " + param1);
			System.out.println("param2 : " + param2);
			
//			if ( reqUrl.equals(resourceManager.getProperty(ICbcFwConstant.LOGIN_ACTION))) { //�α��� ��ûó��
//				User user = loginManager.logIn(httpRequest);//�α��� ��û ó��
//				httpRequest.setAttribute(ICbcFwConstant.CUSER, user);	//TODO session�� User�� �־���´�.. �� request�� �־���� �ʿ䰡 �ִ���....
//				httpRequest.setAttribute(WebLogConfigurator.CUR_PROG_NO, "");	//TODO ��� ������ �־���Ҵ���..
//				writer.write(user, httpResponse);//�α��� ������ ó��
//			} else if (reqUrl.equals(resourceManager.getProperty(ICbcFwConstant.LOGOUT_ACTION))) { //�α׾ƿ� ��ûó��
//				loginManager.logout(httpRequest);
//				writer.write(ICbcFwConstant.SUCCESS, "", httpResponse);	//�����߻��̳��� �α׾ƿ��̹Ƿ� ����
//				if (logger.isDebugEnabled()) {
//					logger.debug("doFilter(ServletRequest, ServletResponse, FilterChain) - end"); //$NON-NLS-1$
//				}
//				return;
//			} else if (reqUrl.equals(resourceManager.getProperty(ICbcFwConstant.CHNG_PSWD_ACTION))){//��й�ȣ ���� ��û��  �α����� ���ص� �ȴ�.
//				chain.doFilter(request, response);
//			} else { 
//				loginManager.chkUserSession(httpRequest);//���� ���� ����
//				chain.doFilter(request, response);//����û ó��
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
