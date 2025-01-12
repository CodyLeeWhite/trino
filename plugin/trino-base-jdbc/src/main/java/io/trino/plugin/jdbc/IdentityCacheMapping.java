/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.trino.plugin.jdbc;

import io.trino.spi.security.ConnectorIdentity;

public interface IdentityCacheMapping
{
    IdentityCacheKey getRemoteUserCacheKey(ConnectorIdentity identity);

    /**
     * This will be used as cache key for metadata. If {@link ConnectorIdentity} content can influence the
     * metadata then we should have {@link IdentityCacheKey} instance so
     * we could cache proper metadata for given {@link ConnectorIdentity}.
     */
    abstract class IdentityCacheKey
    {
        @Override
        public abstract int hashCode();

        @Override
        public abstract boolean equals(Object obj);
    }
}
