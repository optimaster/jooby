/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jooby.internal.spec;

import java.lang.reflect.Type;
import java.util.Optional;

import org.jooby.spec.RouteParam;
import org.jooby.spec.RouteParamType;

import com.google.common.base.MoreObjects;

public class RouteParamImpl extends SerObject implements RouteParam {

  /** default serial. */
  private static final long serialVersionUID = 1L;

  public RouteParamImpl(final String name, final Type type, final RouteParamType paramType,
      final Object defaultValue, final String doc) {
    put("name", name);
    put("type", type);
    put("paramType", paramType.name());
    put("value", defaultValue);
    put("doc", doc);
  }

  protected RouteParamImpl() {
  }

  @Override
  public Object value() {
    return get("value");
  }

  @Override
  public Optional<String> doc() {
    return Optional.ofNullable(get("doc"));
  }

  @Override
  public Type type() {
    return get("type");
  }

  @Override
  public RouteParam type(final Type type) {
    put("type", type);
    return this;
  }

  @Override
  public String name() {
    return get("name");
  }

  @Override
  public RouteParamType paramType() {
    return RouteParamType.valueOf(get("paramType"));
  }

  @Override
  public RouteParam paramType(final RouteParamType type) {
    put("paramType", type.name());
    return this;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper("")
        .add("name", name())
        .add("paramType", paramType())
        .add("type", type())
        .add("value", value())
        .add("doc", doc())
        .toString() + "\n";
  }

}
