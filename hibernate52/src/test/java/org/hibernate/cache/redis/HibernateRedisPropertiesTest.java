/*
 * Copyright (c) 2016. Sunghyouk Bae <sunghyouk.bae@gmail.com>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.hibernate.cache.redis;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.InputStream;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class HibernateRedisPropertiesTest {

  private static final String CACHE_PROPERTIES_PATH = "conf/hibernate-redis.properties";

  @Test
  public void loadProperties() throws Exception {
    Properties props = new Properties();

    log.debug("load hibernate-redis properties. path={}", CACHE_PROPERTIES_PATH);

    InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(CACHE_PROPERTIES_PATH);
    assertThat(is).isNotNull();

    props.load(is);

    log.debug("properties... \n{}", props.toString());
  }
}
