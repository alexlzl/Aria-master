/*
 * Copyright (C) 2016 AriaLyy(https://github.com/AriaLyy/Aria)
 *
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
 */
package com.arialyy.aria.http.download;

import com.arialyy.aria.core.download.DTaskWrapper;
import com.arialyy.aria.core.listener.IEventListener;
import com.arialyy.aria.core.loader.AbsNormalLoader;
import com.arialyy.aria.core.loader.AbsNormalLoaderUtil;
import com.arialyy.aria.core.loader.LoaderStructure;
import com.arialyy.aria.core.loader.NormalLoader;
import com.arialyy.aria.core.loader.NormalTTBuilder;
import com.arialyy.aria.core.loader.NormalThreadStateManager;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;
import com.arialyy.aria.core.wrapper.ITaskWrapper;
import com.arialyy.aria.http.HttpRecordHandler;
import com.arialyy.aria.http.HttpTaskOption;

/**
 * @Author lyy
 * @Date 2019-09-21
 */
public final class HttpDLoaderUtil extends AbsNormalLoaderUtil {

  @Override public AbsNormalLoader getLoader() {
    if (mLoader == null){
      getTaskWrapper().generateTaskOption(HttpTaskOption.class);
      mLoader = new NormalLoader(getTaskWrapper(), getListener());
    }
    return mLoader;
  }

  public LoaderStructure BuildLoaderStructure() {
    LoaderStructure structure = new LoaderStructure();
    structure.addComponent(new HttpRecordHandler(getTaskWrapper()))
        .addComponent(new NormalThreadStateManager(getListener()))
        .addComponent(new HttpDFileInfoTask((DTaskWrapper) getTaskWrapper()))
        .addComponent(new NormalTTBuilder(getTaskWrapper(), new HttpDTTBuilderAdapter()));
    structure.accept(getLoader());
    return structure;
  }
}
