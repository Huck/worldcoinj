/*
 * Copyright 2013 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.worldcoin.params;

import com.google.worldcoin.core.NetworkParameters;
import com.google.worldcoin.core.Utils;

import static com.google.common.base.Preconditions.checkState;

/**
 * Parameters for the main production network on which people trade goods and services.
 */
public class MainNetParams extends NetworkParameters {
    public MainNetParams() {
        super();
        interval = INTERVAL_V2;
        interval_v1 = INTERVAL_V1;
        targetTimespan = TARGET_TIMESPAN_V2;
        proofOfWorkLimit = Utils.decodeCompactBits(0x1e0fffffL);

        addressHeader = 73;
        dumpedPrivateKeyHeader = addressHeader + 128; //This is always addressHeader + 128
        acceptableAddressCodes = new int[]{addressHeader};
        port = 11081;

        // The message start string is designed to be unlikely to occur in normal data.
        // The characters are rarely used upper ASCII, not valid as UTF-8, and produce
        // a large 4-byte int at any alignment.
        //unsigned char pchMessageStart[4] = { 0xfb, 0xc0, 0xb6, 0xdb }; // Worldcoin: increase each by adding 2 to worldcoin's value.
        packetMagic = 0xFBC0B6DB;

        genesisBlock.setDifficultyTarget(0x1e0ffff0L);
        genesisBlock.setTime(1368503907L);
        genesisBlock.setNonce(102158625L);
        id = ID_MAINNET;
        subsidyDecreaseBlockCount = 20160;
        spendableCoinbaseDepth = 70;
        String genesisHash = genesisBlock.getHashAsString();

        checkState(genesisHash.equals("7231b064d3e620c55960abce2963ea19e1c3ffb6f5ff70e975114835a7024107"),
                genesisHash);

        // This contains (at a minimum) the blocks which are not BIP30 compliant. BIP30 changed how duplicate
        // transactions are handled. Duplicated transactions could occur in the case where a coinbase had the same
        // extraNonce and the same outputs but appeared at different heights, and greatly complicated re-org handling.
        // Having these here simplifies block connection logic considerably.
//        checkpoints.put(1, new Sha256Hash("00000000000271a2dc26e7667f8419f2e15416dc6955e5a6c6cdf3f2574dd08e"));
//        checkpoints.put(91812, new Sha256Hash("00000000000af0aed4792b1acee3d966af36cf5def14935db8de83d6f9306f2f"));
//        checkpoints.put(91842, new Sha256Hash("00000000000a4d0a398161ffc163c503763b1f4360639393e0e4c8e300e0caec"));
//        checkpoints.put(91880, new Sha256Hash("00000000000743f190a18c5577a3c2d2a1f610ae9601ac046a38084ccb7cd721"));
//        checkpoints.put(200000, new Sha256Hash("000000000000034a7dedef4a161fa058a2d67a173a90155f3a2fe6fc132e0ebf"));
//
//
//        (     1,      uint256("0x1a48c2bf97e0df6d4f03cd5cb0896ef43b04987048fbeb5ab2dc013335e40731"))
//        (    39,     uint256("0x9d9a9c4c36d95f2188eb9c796deca87f8ac968e4d4ffe423d8445eea56109335"))
//        (    74,     uint256("0xc5621f7aed66b5d34cd1dec8c9f01801ec2193acb0a80f6b3abdbcaeebe9c23f"))
//        (   130,    uint256("0x7a5597740ef7b88e4cd664d8919752e1754d5fe93a1ee04f9844e3ca346475e6"))
//        (   200,    uint256("0x9ebe1c0ee596d5a0552a10d6dc4ef40fad865ca3a178400ba6bcafaefa6320cb"))
//        (749499, uint256("0xa30ea8d5be278f9d7097ffb6bb5fb9af4203f34289382adc4df11800c7e0292b")) //chain prior to a double spend attack
//        (749526, uint256("0x27324520a2ecc22294018679426a12e9aed8b2ef09772b8523effccfae5523cc"))
//        (775845, uint256("0x32d34773724f7821c27fe18f44ea30ec057da48e963f3229a1c584378afbfbf5"))

        dnsSeeds = new String[]{
               "seednode1.worldcoinfoundation.org",
                "seednode2.worldcoinfoundation.org"
           /*    "seednode3.worldcoinfoundation.org",
                "seednode4.worldcoinfoundation.org",
               "seednode5.worldcoinfoundation.org",
               "seednode6.worldcoinfoundation.org",
                "mineworks.scharmbeck.com",*/
        };
    }

    private static MainNetParams instance;

    public static synchronized MainNetParams get() {
        if (instance == null) {
            instance = new MainNetParams();
        }
        return instance;
    }
}
