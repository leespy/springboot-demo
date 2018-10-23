/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package chapter2.demo1;

import org.springframework.stereotype.Service;

/**
 * Singleton的Bean
 *
 * Date 2018/10/24 上午12:22
 * Author lijinlong02@baidu.com
 */
@Service // 默认为Singleton，相当于@Scope("singleton")
public class DemoSingletonService {
}