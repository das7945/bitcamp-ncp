package bitcamp.myapp.listener;


import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration.Dynamic;
import javax.servlet.annotation.WebListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import bitcamp.myapp.config.AppConfig;


@WebListener
public class AppInitListener implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    // Spring Ioc 컨테이너 준비
    AnnotationConfigWebApplicationContext iocContainer = new AnnotationConfigWebApplicationContext();
    iocContainer.register(AppConfig.class);

    //    String[] beanNames = iocContainer.getBeanDefinitionNames();
    //    for (String beanName : beanNames ) {
    //      System.out.printf("%s ==> %s\n", beanName, iocContainer.getBean(beanName).getClass().getName());
    //    }


    // DispatcherServlet  프론트 컨트롤러 준비
    DispatcherServlet dispatcherServlet = new DispatcherServlet(iocContainer);
    Dynamic registration = sce.getServletContext().addServlet("add", dispatcherServlet);
    registration.addMapping("/app/*");
    registration.setLoadOnStartup(1);
    registration.setMultipartConfig(new MultipartConfigElement(
        "/tmp", // 클라이언트가 보낸 파일을 임시 보관 할 폴더
        1024 * 1024 * 10, // 한 파일의 최대 크기
        1024 * 1024 * 10 * 10 , // 한 요청당 최대 파일의 총 파일 크기
        1024 * 1024 * 1 // 클라이언트가 보낸 파일을 메모리에 임시 보관하는 최대 크기
        // 최대 크기를 초과하면 파일에 내보낸다.
        ));
//    System.out.println(System.getProperty("java.io.tmpdir"));

  }
}
