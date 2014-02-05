/*
 * Copyright 2012 the original author or authors.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */

package com.google.worldcoin.uri;

import org.junit.Test;

import java.io.UnsupportedEncodingException;


public class WorldcoinURITest {
    private WorldcoinURI testObject = null;

    private static final String MAINNET_GOOD_ADDRESS = "WUz9fWRbBc3xdCuLAPE62BCCnjYjBENPmD";

    @Test
    public void testConvertToBitcoinURI() throws Exception {
       /* Address goodAddress = new Address(MainNetParams.get(), MAINNET_GOOD_ADDRESS);
        
        // simple example
        assertEquals("worldcoin:" + MAINNET_GOOD_ADDRESS + "?amount=12.34&label=Hello&message=AMessage", WorldcoinURI.convertToWorldcoinURI(goodAddress, Utils.toNanoCoins("12.34"), "Hello", "AMessage"));
        
        // example with spaces, ampersand and plus
        assertEquals("worldcoin:" + MAINNET_GOOD_ADDRESS + "?amount=12.34&label=Hello%20World&message=Mess%20%26%20age%20%2B%20hope", WorldcoinURI.convertToWorldcoinURI(goodAddress, Utils.toNanoCoins("12.34"), "Hello World", "Mess & age + hope"));

        // no amount, label present, message present
        assertEquals("worldcoin:" + MAINNET_GOOD_ADDRESS + "?label=Hello&message=glory", WorldcoinURI.convertToWorldcoinURI(goodAddress, null, "Hello", "glory"));
        
        // amount present, no label, message present
        assertEquals("worldcoin:" + MAINNET_GOOD_ADDRESS + "?amount=0.1&message=glory", WorldcoinURI.convertToWorldcoinURI(goodAddress, Utils.toNanoCoins("0.1"), null, "glory"));
        assertEquals("worldcoin:" + MAINNET_GOOD_ADDRESS + "?amount=0.1&message=glory", WorldcoinURI.convertToWorldcoinURI(goodAddress, Utils.toNanoCoins("0.1"), "", "glory"));

        // amount present, label present, no message
        assertEquals("worldcoin:" + MAINNET_GOOD_ADDRESS + "?amount=12.34&label=Hello", WorldcoinURI.convertToWorldcoinURI(goodAddress, Utils.toNanoCoins("12.34"), "Hello", null));
        assertEquals("worldcoin:" + MAINNET_GOOD_ADDRESS + "?amount=12.34&label=Hello", WorldcoinURI.convertToWorldcoinURI(goodAddress, Utils.toNanoCoins("12.34"), "Hello", ""));
              
        // amount present, no label, no message
        assertEquals("worldcoin:" + MAINNET_GOOD_ADDRESS + "?amount=1000", WorldcoinURI.convertToWorldcoinURI(goodAddress, Utils.toNanoCoins("1000"), null, null));
        assertEquals("worldcoin:" + MAINNET_GOOD_ADDRESS + "?amount=1000", WorldcoinURI.convertToWorldcoinURI(goodAddress, Utils.toNanoCoins("1000"), "", ""));
        
        // no amount, label present, no message
        assertEquals("worldcoin:" + MAINNET_GOOD_ADDRESS + "?label=Hello", WorldcoinURI.convertToWorldcoinURI(goodAddress, null, "Hello", null));
        
        // no amount, no label, message present
        assertEquals("worldcoin:" + MAINNET_GOOD_ADDRESS + "?message=Agatha", WorldcoinURI.convertToWorldcoinURI(goodAddress, null, null, "Agatha"));
        assertEquals("worldcoin:" + MAINNET_GOOD_ADDRESS + "?message=Agatha", WorldcoinURI.convertToWorldcoinURI(goodAddress, null, "", "Agatha"));
      
        // no amount, no label, no message
        assertEquals("worldcoin:" + MAINNET_GOOD_ADDRESS, WorldcoinURI.convertToWorldcoinURI(goodAddress, null, null, null));
        assertEquals("worldcoin:" + MAINNET_GOOD_ADDRESS, WorldcoinURI.convertToWorldcoinURI(goodAddress, null, "", ""));*/
    }

    @Test
    public void testGood_Simple() throws WorldcoinURIParseException {
       /* testObject = new WorldcoinURI(MainNetParams.get(), WorldcoinURI.BITCOIN_SCHEME + ":" + MAINNET_GOOD_ADDRESS);
        assertNotNull(testObject);
        assertNull("Unexpected amount", testObject.getAmount());
        assertNull("Unexpected label", testObject.getLabel());
        assertEquals("Unexpected label", 20, testObject.getAddress().getHash160().length);*/
    }

    /**
     * Test a broken URI (bad scheme)
     */
    @Test
    public void testBad_Scheme() {
      /*  try {
            testObject = new WorldcoinURI(MainNetParams.get(), "blimpcoin:" + MAINNET_GOOD_ADDRESS);
            fail("Expecting WorldcoinURIParseException");
        } catch (WorldcoinURIParseException e) {
        }*/
    }

    /**
     * Test a broken URI (bad syntax)
     */
    @Test
    public void testBad_BadSyntax() {
       /* // Various illegal characters
        try {
            testObject = new WorldcoinURI(MainNetParams.get(), WorldcoinURI.BITCOIN_SCHEME + "|" + MAINNET_GOOD_ADDRESS);
            fail("Expecting WorldcoinURIParseException");
        } catch (WorldcoinURIParseException e) {
            assertTrue(e.getMessage().contains("Bad URI syntax"));
        }

        try {
            testObject = new WorldcoinURI(MainNetParams.get(), WorldcoinURI.BITCOIN_SCHEME + ":" + MAINNET_GOOD_ADDRESS + "\\");
            fail("Expecting WorldcoinURIParseException");
        } catch (WorldcoinURIParseException e) {
            assertTrue(e.getMessage().contains("Bad URI syntax"));
        }

        // Separator without field
        try {
            testObject = new WorldcoinURI(MainNetParams.get(), WorldcoinURI.BITCOIN_SCHEME + ":");
            fail("Expecting WorldcoinURIParseException");
        } catch (WorldcoinURIParseException e) {
            assertTrue(e.getMessage().contains("Bad URI syntax"));
        }*/
    }

    /**
     * Test a broken URI (missing address)
     */
    @Test
    public void testBad_Address() {
        /*try {
            testObject = new WorldcoinURI(MainNetParams.get(), WorldcoinURI.BITCOIN_SCHEME);
            fail("Expecting WorldcoinURIParseException");
        } catch (WorldcoinURIParseException e) {
        }*/
    }

    /**
     * Test a broken URI (bad address type)
     */
    @Test
    public void testBad_IncorrectAddressType() {
       /* try {
            testObject = new WorldcoinURI(MainNetParams.get(), WorldcoinURI.BITCOIN_SCHEME + ":" + "1JKTVKGSDp5aUQzgtWyhbMtsXvW8s2vVRU");
            fail("Expecting WorldcoinURIParseException");
        } catch (WorldcoinURIParseException e) {
            assertTrue(e.getMessage().contains("Bad address"));
        }*/
    }

    /**
     * Handles a simple amount
     * 
     * @throws WorldcoinURIParseException
     *             If something goes wrong
     */
    @Test
    public void testGood_Amount() throws WorldcoinURIParseException {
        /*// Test the decimal parsing
        testObject = new WorldcoinURI(MainNetParams.get(), WorldcoinURI.BITCOIN_SCHEME + ":" + MAINNET_GOOD_ADDRESS
                + "?amount=6543210.12345678");
        assertEquals("654321012345678", testObject.getAmount().toString());

        // Test the decimal parsing
        testObject = new WorldcoinURI(MainNetParams.get(), WorldcoinURI.BITCOIN_SCHEME + ":" + MAINNET_GOOD_ADDRESS
                + "?amount=.12345678");
        assertEquals("12345678", testObject.getAmount().toString());

        // Test the integer parsing
        testObject = new WorldcoinURI(MainNetParams.get(), WorldcoinURI.BITCOIN_SCHEME + ":" + MAINNET_GOOD_ADDRESS
                + "?amount=6543210");
        assertEquals("654321000000000", testObject.getAmount().toString());*/
    }

    /**
     * Handles a simple label
     * 
     * @throws WorldcoinURIParseException
     *             If something goes wrong
     */
    @Test
    public void testGood_Label() throws WorldcoinURIParseException {
        /*testObject = new WorldcoinURI(MainNetParams.get(), WorldcoinURI.BITCOIN_SCHEME + ":" + MAINNET_GOOD_ADDRESS
                + "?label=Hello%20World");
        assertEquals("Hello World", testObject.getLabel());*/
    }

    /**
     * Handles a simple label with an embedded ampersand and plus
     * 
     * @throws WorldcoinURIParseException
     *             If something goes wrong
     * @throws UnsupportedEncodingException 
     */
    @Test
    public void testGood_LabelWithAmpersandAndPlus() throws Exception {
       /* String testString = "Hello Earth & Mars + Venus";
        String encodedLabel = WorldcoinURI.encodeURLString(testString);
        testObject = new WorldcoinURI(MainNetParams.get(), WorldcoinURI.BITCOIN_SCHEME + ":" + MAINNET_GOOD_ADDRESS + "?label="
                + encodedLabel);
        assertEquals(testString, testObject.getLabel());*/
    }

    /**
     * Handles a Russian label (Unicode test)
     * 
     * @throws WorldcoinURIParseException
     *             If something goes wrong
     * @throws UnsupportedEncodingException 
     */
    @Test
    public void testGood_LabelWithRussian() throws Exception {
      /*  // Moscow in Russian in Cyrillic
        String moscowString = "\u041c\u043e\u0441\u043a\u0432\u0430";
        String encodedLabel = WorldcoinURI.encodeURLString(moscowString);
        testObject = new WorldcoinURI(MainNetParams.get(), WorldcoinURI.BITCOIN_SCHEME + ":" + MAINNET_GOOD_ADDRESS + "?label="
                + encodedLabel);
        assertEquals(moscowString, testObject.getLabel());*/
    }

    /**
     * Handles a simple message
     * 
     * @throws WorldcoinURIParseException
     *             If something goes wrong
     */
    @Test
    public void testGood_Message() throws WorldcoinURIParseException {
       /* testObject = new WorldcoinURI(MainNetParams.get(), WorldcoinURI.BITCOIN_SCHEME + ":" + MAINNET_GOOD_ADDRESS
                + "?message=Hello%20World");
        assertEquals("Hello World", testObject.getMessage());*/
    }

    /**
     * Handles various well-formed combinations
     * 
     * @throws WorldcoinURIParseException
     *             If something goes wrong
     */
    @Test
    public void testGood_Combinations() throws WorldcoinURIParseException {
     /*   testObject = new WorldcoinURI(MainNetParams.get(), WorldcoinURI.BITCOIN_SCHEME + ":" + MAINNET_GOOD_ADDRESS
                + "?amount=6543210&label=Hello%20World&message=Be%20well");
        assertEquals(
                "WorldcoinURI['address'='DJKTVKGSDp5aUQzgtWyhbMtsXvW8s2vVRU','amount'='654321000000000','label'='Hello World','message'='Be well']",
                testObject.toString());*/
    }

    /**
     * Handles a badly formatted amount field
     * 
     * @throws WorldcoinURIParseException
     *             If something goes wrong
     */
    @Test
    public void testBad_Amount() throws WorldcoinURIParseException {
       /* // Missing
        try {
            testObject = new WorldcoinURI(MainNetParams.get(), WorldcoinURI.BITCOIN_SCHEME + ":" + MAINNET_GOOD_ADDRESS
                    + "?amount=");
            fail("Expecting WorldcoinURIParseException");
        } catch (WorldcoinURIParseException e) {
            assertTrue(e.getMessage().contains("amount"));
        }

        // Non-decimal (BIP 21)
        try {
            testObject = new WorldcoinURI(MainNetParams.get(), WorldcoinURI.BITCOIN_SCHEME + ":" + MAINNET_GOOD_ADDRESS
                    + "?amount=12X4");
            fail("Expecting WorldcoinURIParseException");
        } catch (WorldcoinURIParseException e) {
            assertTrue(e.getMessage().contains("amount"));
        }*/
    }

    /**
     * Handles a badly formatted label field
     * 
     * @throws WorldcoinURIParseException
     *             If something goes wrong
     */
    @Test
    public void testBad_Label() throws WorldcoinURIParseException {
       /* try {
            testObject = new WorldcoinURI(MainNetParams.get(), WorldcoinURI.BITCOIN_SCHEME + ":" + MAINNET_GOOD_ADDRESS
                    + "?label=");
            fail("Expecting WorldcoinURIParseException");
        } catch (WorldcoinURIParseException e) {
            assertTrue(e.getMessage().contains("label"));
        }*/
    }

    /**
     * Handles a badly formatted message field
     * 
     * @throws WorldcoinURIParseException
     *             If something goes wrong
     */
    @Test
    public void testBad_Message() throws WorldcoinURIParseException {
       /* try {
            testObject = new WorldcoinURI(MainNetParams.get(), WorldcoinURI.BITCOIN_SCHEME + ":" + MAINNET_GOOD_ADDRESS
                    + "?message=");
            fail("Expecting WorldcoinURIParseException");
        } catch (WorldcoinURIParseException e) {
            assertTrue(e.getMessage().contains("message"));
        }*/
    }

    /**
     * Handles duplicated fields (sneaky address overwrite attack)
     * 
     * @throws WorldcoinURIParseException
     *             If something goes wrong
     */
    @Test
    public void testBad_Duplicated() throws WorldcoinURIParseException {
       /* try {
            testObject = new WorldcoinURI(MainNetParams.get(), WorldcoinURI.BITCOIN_SCHEME + ":" + MAINNET_GOOD_ADDRESS
                    + "?address=aardvark");
            fail("Expecting WorldcoinURIParseException");
        } catch (WorldcoinURIParseException e) {
            assertTrue(e.getMessage().contains("address"));
        }*/
    }

    /**
     * Handles case when there are too many equals
     * 
     * @throws WorldcoinURIParseException
     *             If something goes wrong
     */
    @Test
    public void testBad_TooManyEquals() throws WorldcoinURIParseException {
       /* try {
            testObject = new WorldcoinURI(MainNetParams.get(), WorldcoinURI.BITCOIN_SCHEME + ":" + MAINNET_GOOD_ADDRESS
                    + "?label=aardvark=zebra");
            fail("Expecting WorldcoinURIParseException");
        } catch (WorldcoinURIParseException e) {
            assertTrue(e.getMessage().contains("cannot parse name value pair"));
        }*/
    }

    /**
     * Handles case when there are too many question marks
     * 
     * @throws WorldcoinURIParseException
     *             If something goes wrong
     */
    @Test
    public void testBad_TooManyQuestionMarks() throws WorldcoinURIParseException {
       /* try {
            testObject = new WorldcoinURI(MainNetParams.get(), WorldcoinURI.BITCOIN_SCHEME + ":" + MAINNET_GOOD_ADDRESS
                    + "?label=aardvark?message=zebra");
            fail("Expecting WorldcoinURIParseException");
        } catch (WorldcoinURIParseException e) {
            assertTrue(e.getMessage().contains("Too many question marks"));
        }*/
    }
    
    /**
     * Handles unknown fields (required and not required)
     * 
     * @throws WorldcoinURIParseException
     *             If something goes wrong
     */
    @Test
    public void testUnknown() throws WorldcoinURIParseException {
      /*  // Unknown not required field
        testObject = new WorldcoinURI(MainNetParams.get(), WorldcoinURI.BITCOIN_SCHEME + ":" + MAINNET_GOOD_ADDRESS
                + "?aardvark=true");
        assertEquals("WorldcoinURI['address'='DJKTVKGSDp5aUQzgtWyhbMtsXvW8s2vVRU','aardvark'='true']", testObject.toString());

        assertEquals("true", (String) testObject.getParameterByName("aardvark"));

        // Unknown not required field (isolated)
        try {
            testObject = new WorldcoinURI(MainNetParams.get(), WorldcoinURI.BITCOIN_SCHEME + ":" + MAINNET_GOOD_ADDRESS
                    + "?aardvark");
            fail("Expecting WorldcoinURIParseException");
        } catch (WorldcoinURIParseException e) {
            assertTrue(e.getMessage().contains("cannot parse name value pair"));
        }

        // Unknown and required field
        try {
            testObject = new WorldcoinURI(MainNetParams.get(), WorldcoinURI.BITCOIN_SCHEME + ":" + MAINNET_GOOD_ADDRESS
                    + "?req-aardvark=true");
            fail("Expecting WorldcoinURIParseException");
        } catch (WorldcoinURIParseException e) {
            assertTrue(e.getMessage().contains("req-aardvark"));
        }*/
    }

    @Test
    public void brokenURIs() throws WorldcoinURIParseException {
       /* // Check we can parse the incorrectly formatted URIs produced by blockchain.info and its iPhone app.
        String str = "worldcoin://1KzTSfqjF2iKCduwz59nv2uqh1W2JsTxZH?amount=0.01000000";
        WorldcoinURI uri = new WorldcoinURI(str);
        assertEquals("1KzTSfqjF2iKCduwz59nv2uqh1W2JsTxZH", uri.getAddress().toString());
        assertEquals(Utils.toNanoCoins(0, 1), uri.getAmount());*/
    }

    /*@Test(expected = WorldcoinURIParseException.class)
    public void testBad_AmountTooPrecise() throws WorldcoinURIParseException {
        new WorldcoinURI(MainNetParams.get(), WorldcoinURI.BITCOIN_SCHEME + ":" + MAINNET_GOOD_ADDRESS
                + "?amount=0.123456789");
    }*/

  /*  @Test(expected = WorldcoinURIParseException.class)
    public void testBad_NegativeAmount() throws WorldcoinURIParseException {
        new WorldcoinURI(MainNetParams.get(), WorldcoinURI.BITCOIN_SCHEME + ":" + MAINNET_GOOD_ADDRESS
                + "?amount=-1");
    }*/

   /* @Test(expected = WorldcoinURIParseException.class)
    public void testBad_TooLargeAmount() throws WorldcoinURIParseException {
       new WorldcoinURI(MainNetParams.get(), WorldcoinURI.BITCOIN_SCHEME + ":" + MAINNET_GOOD_ADDRESS
                + "?amount=100000000000000");
    }*/
}
