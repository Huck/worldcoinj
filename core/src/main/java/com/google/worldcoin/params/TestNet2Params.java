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
 * Parameters for the old version 2 testnet. This is not useful to you - it exists only because some unit tests are
 * based on it.
 */
public class TestNet2Params extends NetworkParameters {
    public TestNet2Params() {
        super();
        id = ID_TESTNET;
        packetMagic = 0xFBC0B6DB;
        port = 11081;
        addressHeader = 73;
        acceptableAddressCodes = new int[] { addressHeader };
        interval = INTERVAL_V2;
        interval_v1 = INTERVAL_V1;
        targetTimespan = TARGET_TIMESPAN_V2;
        proofOfWorkLimit = Utils.decodeCompactBits(0x1e0fffffL);
        dumpedPrivateKeyHeader = 201;
        genesisBlock.setDifficultyTarget(0x1e0ffff0L);
        genesisBlock.setTime(1368503907L);
        genesisBlock.setNonce(102158625L);
        spendableCoinbaseDepth = 100;
        subsidyDecreaseBlockCount = 20160;
        String genesisHash = genesisBlock.getHashAsString();
        checkState(genesisHash.equals("7231b064d3e620c55960abce2963ea19e1c3ffb6f5ff70e975114835a7024107"));
        dnsSeeds = null;
    }

    private static TestNet2Params instance;
    public static synchronized TestNet2Params get() {
        if (instance == null) {
            instance = new TestNet2Params();
        }
        return instance;
    }
}
