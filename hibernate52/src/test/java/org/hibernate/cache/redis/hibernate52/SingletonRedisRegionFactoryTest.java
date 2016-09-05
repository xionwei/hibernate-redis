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

package org.hibernate.cache.redis.hibernate52;

import org.hibernate.cache.redis.strategy.ItemValueExtractor;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Map;

public class SingletonRedisRegionFactoryTest extends AbstractHibernateCacheTest {

  @Override
  protected void configCache(Configuration cfg) {

    cfg.setProperty(Environment.CACHE_REGION_FACTORY,
                    SingletonRedisRegionFactory.class.getName());
    cfg.setProperty(Environment.CACHE_PROVIDER_CONFIG, "conf/hibernate-redis.properties");
  }

  @Override
  protected Map getMapFromCacheEntry(Object entry) {
    final Map map;

    if (entry.getClass()
             .getName()
             .equals(HIBERNATE_ITEM_CLASS_NAME)) {
      map = ItemValueExtractor.getValue(entry);
    } else {
      map = (Map) entry;
    }

    return map;
  }
}
