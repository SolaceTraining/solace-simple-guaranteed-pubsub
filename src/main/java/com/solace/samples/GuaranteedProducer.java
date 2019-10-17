/*
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

package com.solace.samples;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.solacesystems.jcsmp.DeliveryMode;
import com.solacesystems.jcsmp.EndpointProperties;
import com.solacesystems.jcsmp.JCSMPException;
import com.solacesystems.jcsmp.JCSMPFactory;
import com.solacesystems.jcsmp.JCSMPProperties;
import com.solacesystems.jcsmp.JCSMPSession;
import com.solacesystems.jcsmp.JCSMPStreamingPublishEventHandler;
import com.solacesystems.jcsmp.Queue;
import com.solacesystems.jcsmp.TextMessage;
import com.solacesystems.jcsmp.XMLMessageProducer;

public class GuaranteedProducer {

    public static void main(String... args) throws JCSMPException, InterruptedException {

        String host = "tcp://vmr-mr8v6yiwieih.messaging.solace.cloud:20256";
        String vpn = "msgvpn-rwtxvklrlfp";
        String username = "solace-cloud-client";
        String password = "bgpmucb2psrre7eo6bt00cc6cu";
        String queueName = "testQueue";

        if (host.equals("")) {
            System.out.println("Connection details required.");
            System.exit(1);
        }
        
        System.out.println("GuaranteedProducer initializing...");
        // Create a JCSMP Session
        final JCSMPProperties properties = new JCSMPProperties();
        properties.setProperty(JCSMPProperties.HOST, host);     // host:port
        properties.setProperty(JCSMPProperties.USERNAME, username); // client-username
        properties.setProperty(JCSMPProperties.VPN_NAME,  vpn); // message-vpn
        properties.setProperty(JCSMPProperties.PASSWORD, password); // client-password
        properties.setProperty(JCSMPProperties.GENERATE_SEQUENCE_NUMBERS, true); // generate publisher-specific sequence numbers

        final JCSMPSession session = JCSMPFactory.onlyInstance().createSession(properties);

        session.connect();

        final Queue queue = JCSMPFactory.onlyInstance().createQueue(queueName);

        /** Anonymous inner-class for handling publishing events */
        final XMLMessageProducer prod = session.getMessageProducer(
                new JCSMPStreamingPublishEventHandler() {
                    @Override
                    public void responseReceived(String messageID) {
                        System.out.printf("Producer received response for msg ID #%s%n",messageID);
                    }
                    @Override
                    public void handleError(String messageID, JCSMPException e, long timestamp) {
                        System.out.printf("Producer received error for msg ID %s @ %s - %s%n",
                                messageID,timestamp,e);
                    }
                });

        TextMessage msg = JCSMPFactory.onlyInstance().createMessage(TextMessage.class);
        msg.setDeliveryMode(DeliveryMode.PERSISTENT);

        for (int i = 0; i < 10; i++) {
            String text = "Guaranteed Producer " +DateFormat.getDateTimeInstance().format(new Date());
            msg.setText(text);

            // Send message directly to the queue
            prod.send(msg, queue);
            TimeUnit.SECONDS.sleep(1);
        }
	    
        System.out.println("Messages sent. Exiting.");

        // Close session
        session.closeSession();
    }
}
