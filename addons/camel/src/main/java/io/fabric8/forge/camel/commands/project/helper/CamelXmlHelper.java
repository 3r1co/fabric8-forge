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
package io.fabric8.forge.camel.commands.project.helper;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public final class CamelXmlHelper {

    public static Node findEndpointById(Document dom, String endpointId) {
        NodeList list = dom.getElementsByTagName("endpoint");
        for (int i = 0; i < list.getLength(); i++) {
            Node child = list.item(i);
            if ("endpoint".equals(child.getNodeName())) {
                // okay its an endpoint so if we can match by id attribute
                String id = child.getAttributes().getNamedItem("id").getNodeValue();
                if (endpointId.equals(id)) {
                    return child;
                }
            }
        }
        return null;
    }

    public static List<Node> findAllEndpoints(Document dom) {
        List<Node> nodes = new ArrayList<>();

        NodeList list = dom.getElementsByTagName("endpoint");
        for (int i = 0; i < list.getLength(); i++) {
            Node child = list.item(i);
            if ("endpoint".equals(child.getNodeName())) {
                // it may not be a camel namespace, so skip those
                String ns = child.getNamespaceURI();
                if (ns == null) {
                    NamedNodeMap attrs = child.getAttributes();
                    if (attrs != null) {
                        Node node = attrs.getNamedItem("xmlns");
                        if (node != null) {
                            ns = node.getNodeValue();
                        }
                    }
                }
                // assume no namespace its for camel
                if (ns == null || ns.contains("camel")) {
                    nodes.add(child);
                }
            }
        }
        list = dom.getElementsByTagName("route");
        for (int i = 0; i < list.getLength(); i++) {
            Node child = list.item(i);
            if ("route".equals(child.getNodeName())) {
                findAllUrisRecursive(child, nodes);
            }
        }

        return nodes;
    }

    private static void findAllUrisRecursive(Node node, List<Node> nodes) {
        // okay its a route so grab all uri attributes we can find
        String url = getSafeAttribute(node, "uri");
        if (url != null) {
            nodes.add(node);
        }

        NodeList children = node.getChildNodes();
        if (children != null) {
            for (int i = 0; i < children.getLength(); i++) {
                Node child = children.item(i);
                if (child.getNodeType() == Node.ELEMENT_NODE) {
                    findAllUrisRecursive(child, nodes);
                }
            }
        }
    }

    public static List<Node> findAllSimpleExpressions(Document dom) {
        List<Node> nodes = new ArrayList<>();

        NodeList list = dom.getElementsByTagName("route");
        for (int i = 0; i < list.getLength(); i++) {
            Node child = list.item(i);
            if ("route".equals(child.getNodeName())) {
                findAllSimpleExpressionsRecursive(child, nodes);
            }
        }

        return nodes;
    }

    private static void findAllSimpleExpressionsRecursive(Node node, List<Node> nodes) {
        // okay its a route so grab if its <simple>
        if ("simple".equals(node.getNodeName())) {
            nodes.add(node);
        }

        NodeList children = node.getChildNodes();
        if (children != null) {
            for (int i = 0; i < children.getLength(); i++) {
                Node child = children.item(i);
                if (child.getNodeType() == Node.ELEMENT_NODE) {
                    findAllSimpleExpressionsRecursive(child, nodes);
                }
            }
        }
    }

    public static String getSafeAttribute(Node node, String key) {
        if (node != null) {
            Node attr = node.getAttributes().getNamedItem(key);
            if (attr != null) {
                return attr.getNodeValue();
            }
        }
        return null;
    }

    public static String trimEndpointUri(String uri) {
        uri = uri.trim();
        // if the uri is using new-lines then remove whitespace noise before & and ? separator
        uri = uri.replaceAll("(\\s+)(\\&)", "$2");
        uri = uri.replaceAll("(\\&)(\\s+)", "$1");
        uri = uri.replaceAll("(\\?)(\\s+)", "$1");
        return uri;
    }
}
