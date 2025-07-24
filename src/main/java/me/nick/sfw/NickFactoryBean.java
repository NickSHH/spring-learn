package me.nick.sfw;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NickFactoryBean implements FactoryBean {

    @Override
    @Nullable
    public Object getObject() throws Exception {
        return new Amdin();
    }

    @Override
    @Nullable
    public Class getObjectType() {
        return Amdin.class;
    }

}
