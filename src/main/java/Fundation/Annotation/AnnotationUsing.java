package Fundation.Annotation;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import java.lang.annotation.Annotation;
import java.lang.annotation.Inherited;

/**
 * Created：Jeffrey
 * date   ：2020/12/29 22:05
 */
@AnnotationInstance(age = 2, hobby = {"basketball"})
@AnnotationInstance002(name = "")
@Controller
@Service
//@Inherited
@WebServlet(initParams = {@WebInitParam(name = "2", value = "1")})
public class AnnotationUsing {
    //Getting annotation information by reflection
    public static void main(String[] args) {
        System.out.println(AnnotationUsing.class.getAnnotations().length);//获取注释数量
        Class cla = AnnotationUsing.class;
        cla.getTypeName();

        Annotation[] annotations = cla.getAnnotations();

        //获取指定注解
        AnnotationInstance annotationInstance = (AnnotationInstance) cla.getAnnotation(AnnotationInstance.class);
        annotationInstance.age();
        annotationInstance.hobby();


    }
}
