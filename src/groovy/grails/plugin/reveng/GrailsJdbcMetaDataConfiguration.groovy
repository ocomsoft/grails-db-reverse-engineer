/* Copyright 2010-2012 SpringSource.
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
package grails.plugin.reveng

import org.hibernate.cfg.JDBCMetaDataConfiguration
import org.hibernate.cfg.reveng.ReverseEngineeringStrategy

/**
 * Creates a GrailsJdbcBinder to register a logging ProgressListener.
 *
 * @author <a href='mailto:burt@burtbeckwith.com'>Burt Beckwith</a>
 */
class GrailsJdbcMetaDataConfiguration extends JDBCMetaDataConfiguration {

	void readFromJDBC(String defaultCatalog, String defaultSchema) {

		GrailsJdbcBinder binder = new GrailsJdbcBinder(
			this, buildSettings(), createMappings(), getReverseEngineeringStrategy())

		binder.readFromDatabase defaultCatalog, defaultSchema, buildMapping(this)
	}
}
