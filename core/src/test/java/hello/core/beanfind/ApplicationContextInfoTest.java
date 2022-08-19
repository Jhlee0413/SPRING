package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    //자바 설정에서 정보를 읽어와 빈 객체를 생성, 관리한다.

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames(); //ac.getBeanDefinitionNames(): 스프링에 등록된 모든 빈 이름 조회
        for (String beanDefinitionName : beanDefinitionNames) {
           Object bean =  ac.getBean(beanDefinitionName); //ac.getBean(): 빈 이름으로 빈 객체(인스턴스)를 조회
            System.out.println("name =" + beanDefinitionName + " object = " + bean);
        }

    }
    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName); //빈에 대한 메타데이터 정보

            //Role ROLE_APPLICATION: 직접 등록한 애플리케이션
            //Role ROLE_INFRASTUCTURE : 스프링 내부에서 사용하는 빈
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name = " + beanDefinitionName + " object =" + bean);
            }
        }

    }
}
