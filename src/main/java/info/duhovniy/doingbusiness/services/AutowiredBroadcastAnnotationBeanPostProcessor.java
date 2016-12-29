package info.duhovniy.doingbusiness.services;

import info.duhovniy.doingbusiness.config.DataConfig;
import info.duhovniy.doingbusiness.config.UserConfig;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.io.Serializable;
import java.lang.reflect.Field;


@Component
@AllArgsConstructor
public class AutowiredBroadcastAnnotationBeanPostProcessor implements BeanPostProcessor {

    private DataConfig dataConfig;

    private UserConfig userConfig;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        for(Field field:fields) {
            AutowiredBroadcast annotation = field.getAnnotation(AutowiredBroadcast.class);
            if(annotation != null) {
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, dataConfig.javaSparkContext().broadcast(userConfig));
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
