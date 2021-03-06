/**
 *  Copyright 2005-2015 Red Hat, Inc.
 *
 *  Red Hat licenses this file to you under the Apache License, version
 *  2.0 (the "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *  implied.  See the License for the specific language governing
 *  permissions and limitations under the License.
 */
package io.fabric8.forge.camel.commands.project.model;

public class CamelEndpointDetails {

    private String fileName;
    private String lineNumber;
    private String lineNumberEnd;
    private String className;
    private String methodName;
    private String endpointComponentName;
    private String endpointInstance;
    private String endpointUri;
    private boolean consumerOnly;
    private boolean producerOnly;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getLineNumberEnd() {
        return lineNumberEnd;
    }

    public void setLineNumberEnd(String lineNumberEnd) {
        this.lineNumberEnd = lineNumberEnd;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getEndpointComponentName() {
        return endpointComponentName;
    }

    public void setEndpointComponentName(String endpointComponentName) {
        this.endpointComponentName = endpointComponentName;
    }

    public String getEndpointInstance() {
        return endpointInstance;
    }

    public void setEndpointInstance(String endpointInstance) {
        this.endpointInstance = endpointInstance;
    }

    public String getEndpointUri() {
        return endpointUri;
    }

    public void setEndpointUri(String endpointUri) {
        this.endpointUri = endpointUri;
    }

    public boolean isConsumerOnly() {
        return consumerOnly;
    }

    public void setConsumerOnly(boolean consumerOnly) {
        this.consumerOnly = consumerOnly;
    }

    public boolean isProducerOnly() {
        return producerOnly;
    }

    public void setProducerOnly(boolean producerOnly) {
        this.producerOnly = producerOnly;
    }

    @Override
    public String toString() {
        return endpointUri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CamelEndpointDetails that = (CamelEndpointDetails) o;

        if (!fileName.equals(that.fileName)) return false;
        if (lineNumber != null ? !lineNumber.equals(that.lineNumber) : that.lineNumber != null) return false;
        if (lineNumberEnd != null ? !lineNumberEnd.equals(that.lineNumberEnd) : that.lineNumberEnd != null) return false;
        if (!className.equals(that.className)) return false;
        if (methodName != null ? !methodName.equals(that.methodName) : that.methodName != null) return false;
        if (endpointInstance != null ? !endpointInstance.equals(that.endpointInstance) : that.endpointInstance != null)
            return false;
        return endpointUri.equals(that.endpointUri);

    }

    @Override
    public int hashCode() {
        int result = fileName.hashCode();
        result = 31 * result + (lineNumber != null ? lineNumber.hashCode() : 0);
        result = 31 * result + (lineNumberEnd != null ? lineNumberEnd.hashCode() : 0);
        result = 31 * result + className.hashCode();
        result = 31 * result + (methodName != null ? methodName.hashCode() : 0);
        result = 31 * result + (endpointInstance != null ? endpointInstance.hashCode() : 0);
        result = 31 * result + endpointUri.hashCode();
        return result;
    }
}
