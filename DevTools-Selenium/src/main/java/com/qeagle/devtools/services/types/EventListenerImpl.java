package com.qeagle.devtools.services.types;

/*-
 * #%L
 * cdt-java-client
 * %%
 * Copyright (C) 2018 TL
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.qeagle.devtools.protocol.support.types.EventHandler;
import com.qeagle.devtools.protocol.support.types.EventListener;
import com.qeagle.devtools.services.ChromeDevToolsService;

/**
 * Event listener implementation.
 *
 * @author Gopinath
 */
public class EventListenerImpl implements EventListener {
  private ChromeDevToolsService service;

  private String key;
  private EventHandler handler;
  private Class<?> paramType;

  /**
   * Instantiates a new Event listener.
   *
   * @param key Domain.event key.
   * @param handler Event handler.
   * @param paramType Event param type.
   * @param service Service.
   */
  public EventListenerImpl(
      String key, EventHandler handler, Class<?> paramType, ChromeDevToolsService service) {
    this.service = service;
    this.key = key;
    this.paramType = paramType;
    this.handler = handler;
  }

  @Override
  public void off() {
    unsubscribe();
  }

  @Override
  public void unsubscribe() {
    service.removeEventListener(this);
  }

  /**
   * Gets the domain.event key.
   *
   * @return Key. key
   */
  public String getKey() {
    return key;
  }

  /**
   * Gets the event handler.
   *
   * @return Event handler.
   */
  public EventHandler getHandler() {
    return handler;
  }

  /**
   * Gets param type.
   *
   * @return Event param type.
   */
  public Class<?> getParamType() {
    return paramType;
  }
}
