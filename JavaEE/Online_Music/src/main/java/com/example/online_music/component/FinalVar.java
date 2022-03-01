package com.example.online_music.component;

import org.springframework.util.ClassUtils;

import java.util.Objects;

public class FinalVar {
    public static final String APP_PATH= Objects.requireNonNull(Objects.requireNonNull(ClassUtils.getDefaultClassLoader()).getResource("static")).getPath();
}
