.. SPDX-License-Identifier: CC-BY-SA-2.0-UK

Release notes for Yocto-4.0.13 (Kirkstone)
------------------------------------------

Security Fixes in Yocto-4.0.13
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

-  bind: Fix :cve:`2023-2829`
-  binutils: Fix :cve:`2022-48065`
-  busybox: Fix :cve:`2022-48174`
-  cups: Fix :cve:`2023-32360`
-  curl: Fix :cve:`2023-32001`
-  dmidecode: Fix :cve:`2023-30630`
-  dropbear: Fix :cve:`2023-36328`
-  ffmpeg: Ignored :cve:`2023-39018`
-  file: Fix :cve:`2022-48554`
-  flac: Fix :cve:`2020-22219`
-  gcc: Fix :cve:`2023-4039`
-  gdb: Fix :cve:`2023-39128`
-  ghostscript: Fix :cve:`2023-38559`
-  glib-2.0: Fix :cve:`2023-29499`, :cve:`2023-32611`, :cve:`2023-32636`, :cve:`2023-32643` and :cve:`2023-32665`
-  go: Fix :cve:`2023-29409` and :cve:`2023-39319`
-  gstreamer1.0-plugins-bad: Fix :cve_mitre:`2023-37329`
-  gstreamer1.0-plugins-base: Fix :cve_mitre:`2023-37328`
-  gstreamer1.0-plugins-good: Fix :cve_mitre:`2023-37327`
-  inetutils: Fix :cve:`2023-40303`
-  json-c: Fix :cve:`2021-32292`
-  librsvg: Fix :cve:`2023-38633`
-  libssh2: Fix :cve:`2020-22218`
-  libtiff: Fix :cve:`2023-26966`
-  libxml2: Fix :cve:`2023-39615`
-  linux-yocto/5.15: Ignore :cve:`2003-1604`, :cve:`2004-0230`, :cve:`2006-3635`, :cve:`2006-5331`, :cve:`2006-6128`, :cve:`2007-4774`, :cve:`2007-6761`, :cve:`2007-6762`, :cve:`2008-7316`, :cve:`2009-2692`, :cve:`2010-0008`, :cve:`2010-3432`, :cve:`2010-4648`, :cve:`2010-5313`, :cve:`2010-5328`, :cve:`2010-5329`, :cve:`2010-5331`, :cve:`2010-5332`, :cve:`2011-4098`, :cve:`2011-4131`, :cve:`2011-4915`, :cve:`2011-5321`, :cve:`2011-5327`, :cve:`2012-0957`, :cve:`2012-2119`, :cve:`2012-2136`, :cve:`2012-2137`, :cve:`2012-2313`, :cve:`2012-2319`, :cve:`2012-2372`, :cve:`2012-2375`, :cve:`2012-2390`, :cve:`2012-2669`, :cve:`2012-2744`, :cve:`2012-2745`, :cve:`2012-3364`, :cve:`2012-3375`, :cve:`2012-3400`, :cve:`2012-3412`, :cve:`2012-3430`, :cve:`2012-3510`, :cve:`2012-3511`, :cve:`2012-3520`, :cve:`2012-3552`, :cve:`2012-4398`, :cve:`2012-4444`, :cve:`2012-4461`, :cve:`2012-4467`, :cve:`2012-4508`, :cve:`2012-4530`, :cve:`2012-4565`, :cve:`2012-5374`, :cve:`2012-5375`, :cve:`2012-5517`, :cve:`2012-6536`, :cve:`2012-6537`, :cve:`2012-6538`, :cve:`2012-6539`, :cve:`2012-6540`, :cve:`2012-6541`, :cve:`2012-6542`, :cve:`2012-6543`, :cve:`2012-6544`, :cve:`2012-6545`, :cve:`2012-6546`, :cve:`2012-6547`, :cve:`2012-6548`, :cve:`2012-6549`, :cve:`2012-6638`, :cve:`2012-6647`, :cve:`2012-6657`, :cve:`2012-6689`, :cve:`2012-6701`, :cve:`2012-6703`, :cve:`2012-6704`, :cve:`2012-6712`, :cve:`2013-0160`, :cve:`2013-0190`, :cve:`2013-0216`, :cve:`2013-0217`, :cve:`2013-0228`, :cve:`2013-0231`, :cve:`2013-0268`, :cve:`2013-0290`, :cve:`2013-0309`, :cve:`2013-0310`, :cve:`2013-0311`, :cve:`2013-0313`, :cve:`2013-0343`, :cve:`2013-0349`, :cve:`2013-0871`, :cve:`2013-0913`, :cve:`2013-0914`, :cve:`2013-1059`, :cve:`2013-1763`, :cve:`2013-1767`, :cve:`2013-1772`, :cve:`2013-1773`, :cve:`2013-1774`, :cve:`2013-1792`, :cve:`2013-1796`, :cve:`2013-1797`, :cve:`2013-1798`, :cve:`2013-1819`, :cve:`2013-1826`, :cve:`2013-1827`, :cve:`2013-1828`, :cve:`2013-1848`, :cve:`2013-1858`, :cve:`2013-1860`, :cve:`2013-1928`, :cve:`2013-1929`, :cve:`2013-1943`, :cve:`2013-1956`, :cve:`2013-1957`, :cve:`2013-1958`, :cve:`2013-1959`, :cve:`2013-1979`, :cve:`2013-2015`, :cve:`2013-2017`, :cve:`2013-2058`, :cve:`2013-2094`, :cve:`2013-2128`, :cve:`2013-2140`, :cve:`2013-2141`, :cve:`2013-2146`, :cve:`2013-2147`, :cve:`2013-2148`, :cve:`2013-2164`, :cve:`2013-2206`, :cve:`2013-2232`, :cve:`2013-2234`, :cve:`2013-2237`, :cve:`2013-2546`, :cve:`2013-2547`, :cve:`2013-2548`, :cve:`2013-2596`, :cve:`2013-2634`, :cve:`2013-2635`, :cve:`2013-2636`, :cve:`2013-2850`, :cve:`2013-2851`, :cve:`2013-2852`, :cve:`2013-2888`, :cve:`2013-2889`, :cve:`2013-2890`, :cve:`2013-2891`, :cve:`2013-2892`, :cve:`2013-2893`, :cve:`2013-2894`, :cve:`2013-2895`, :cve:`2013-2896`, :cve:`2013-2897`, :cve:`2013-2898`, :cve:`2013-2899`, :cve:`2013-2929`, :cve:`2013-2930`, :cve:`2013-3076`, :cve:`2013-3222`, :cve:`2013-3223`, :cve:`2013-3224`, :cve:`2013-3225`, :cve:`2013-3226`, :cve:`2013-3227`, :cve:`2013-3228`, :cve:`2013-3229`, :cve:`2013-3230`, :cve:`2013-3231`, :cve:`2013-3232`, :cve:`2013-3233`, :cve:`2013-3234`, :cve:`2013-3235`, :cve:`2013-3236`, :cve:`2013-3237`, :cve:`2013-3301`, :cve:`2013-3302`, :cve:`2013-4125`, :cve:`2013-4127`, :cve:`2013-4129`, :cve:`2013-4162`, :cve:`2013-4163`, :cve:`2013-4205`, :cve:`2013-4220`, :cve:`2013-4247`, :cve:`2013-4254`, :cve:`2013-4270`, :cve:`2013-4299`, :cve:`2013-4300`, :cve:`2013-4312`, :cve:`2013-4343`, :cve:`2013-4345`, :cve:`2013-4348`, :cve:`2013-4350`, :cve:`2013-4387`, :cve:`2013-4470`, :cve:`2013-4483`, :cve:`2013-4511`, :cve:`2013-4512`, :cve:`2013-4513`, :cve:`2013-4514`, :cve:`2013-4515`, :cve:`2013-4516`, :cve:`2013-4563`, :cve:`2013-4579`, :cve:`2013-4587`, :cve:`2013-4588`, :cve:`2013-4591`, :cve:`2013-4592`, :cve:`2013-5634`, :cve:`2013-6282`, :cve:`2013-6367`, :cve:`2013-6368`, :cve:`2013-6376`, :cve:`2013-6378`, :cve:`2013-6380`, :cve:`2013-6381`, :cve:`2013-6382`, :cve:`2013-6383`, :cve:`2013-6431`, :cve:`2013-6432`, :cve:`2013-6885`, :cve:`2013-7026`, :cve:`2013-7027`, :cve:`2013-7263`, :cve:`2013-7264`, :cve:`2013-7265`, :cve:`2013-7266`, :cve:`2013-7267`, :cve:`2013-7268`, :cve:`2013-7269`, :cve:`2013-7270`, :cve:`2013-7271`, :cve:`2013-7281`, :cve:`2013-7339`, :cve:`2013-7348`, :cve:`2013-7421`, :cve:`2013-7446`, :cve:`2013-7470`, :cve:`2014-0038`, :cve:`2014-0049`, :cve:`2014-0055`, :cve:`2014-0069`, :cve:`2014-0077`, :cve:`2014-0100`, :cve:`2014-0101`, :cve:`2014-0102`, :cve:`2014-0131`, :cve:`2014-0155`, :cve:`2014-0181`, :cve:`2014-0196`, :cve:`2014-0203`, :cve:`2014-0205`, :cve:`2014-0206`, :cve:`2014-1438`, :cve:`2014-1444`, :cve:`2014-1445`, :cve:`2014-1446`, :cve:`2014-1690`, :cve:`2014-1737`, :cve:`2014-1738`, :cve:`2014-1739`, :cve:`2014-1874`, :cve:`2014-2038`, :cve:`2014-2039`, :cve:`2014-2309`, :cve:`2014-2523`, :cve:`2014-2568`, :cve:`2014-2580`, :cve:`2014-2672`, :cve:`2014-2673`, :cve:`2014-2678`, :cve:`2014-2706`, :cve:`2014-2739`, :cve:`2014-2851`, :cve:`2014-2889`, :cve:`2014-3122`, :cve:`2014-3144`, :cve:`2014-3145`, :cve:`2014-3153`, :cve:`2014-3180`, :cve:`2014-3181`, :cve:`2014-3182`, :cve:`2014-3183`, :cve:`2014-3184`, :cve:`2014-3185`, :cve:`2014-3186`, :cve:`2014-3534`, :cve:`2014-3535`, :cve:`2014-3601`, :cve:`2014-3610`, :cve:`2014-3611`, :cve:`2014-3631`, :cve:`2014-3645`, :cve:`2014-3646`, :cve:`2014-3647`, :cve:`2014-3673`, :cve:`2014-3687`, :cve:`2014-3688`, :cve:`2014-3690`, :cve:`2014-3917`, :cve:`2014-3940`, :cve:`2014-4014`, :cve:`2014-4027`, :cve:`2014-4157`, :cve:`2014-4171`, :cve:`2014-4508`, :cve:`2014-4608`, :cve:`2014-4611`, :cve:`2014-4652`, :cve:`2014-4653`, :cve:`2014-4654`, :cve:`2014-4655`, :cve:`2014-4656`, :cve:`2014-4667`, :cve:`2014-4699`, :cve:`2014-4943`, :cve:`2014-5045`, :cve:`2014-5077`, :cve:`2014-5206`, :cve:`2014-5207`, :cve:`2014-5471`, :cve:`2014-5472`, :cve:`2014-6410`, :cve:`2014-6416`, :cve:`2014-6417`, :cve:`2014-6418`, :cve:`2014-7145`, :cve:`2014-7283`, :cve:`2014-7284`, :cve:`2014-7822`, :cve:`2014-7825`, :cve:`2014-7826`, :cve:`2014-7841`, :cve:`2014-7842`, :cve:`2014-7843`, :cve:`2014-7970`, :cve:`2014-7975`, :cve:`2014-8086`, :cve:`2014-8133`, :cve:`2014-8134`, :cve:`2014-8159`, :cve:`2014-8160`, :cve:`2014-8171`, :cve:`2014-8172`, :cve:`2014-8173`, :cve:`2014-8369`, :cve:`2014-8480`, :cve:`2014-8481`, :cve:`2014-8559`, :cve:`2014-8709`, :cve:`2014-8884`, :cve:`2014-8989`, :cve:`2014-9090`, :cve:`2014-9322`, :cve:`2014-9419`, :cve:`2014-9420`, :cve:`2014-9428`, :cve:`2014-9529`, :cve:`2014-9584`, :cve:`2014-9585`, :cve:`2014-9644`, :cve:`2014-9683`, :cve:`2014-9710`, :cve:`2014-9715`, :cve:`2014-9717`, :cve:`2014-9728`, :cve:`2014-9729`, :cve:`2014-9730`, :cve:`2014-9731`, :cve:`2014-9803`, :cve:`2014-9870`, :cve:`2014-9888`, :cve:`2014-9895`, :cve:`2014-9903`, :cve:`2014-9904`, :cve:`2014-9914`, :cve:`2014-9922`, :cve:`2014-9940`, :cve:`2015-0239`, :cve:`2015-0274`, :cve:`2015-0275`, :cve:`2015-1333`, :cve:`2015-1339`, :cve:`2015-1350`, :cve:`2015-1420`, :cve:`2015-1421`, :cve:`2015-1465`, :cve:`2015-1573`, :cve:`2015-1593`, :cve:`2015-1805`, :cve:`2015-2041`, :cve:`2015-2042`, :cve:`2015-2150`, :cve:`2015-2666`, :cve:`2015-2672`, :cve:`2015-2686`, :cve:`2015-2830`, :cve:`2015-2922`, :cve:`2015-2925`, :cve:`2015-3212`, :cve:`2015-3214`, :cve:`2015-3288`, :cve:`2015-3290`, :cve:`2015-3291`, :cve:`2015-3331`, :cve:`2015-3339`, :cve:`2015-3636`, :cve:`2015-4001`, :cve:`2015-4002`, :cve:`2015-4003`, :cve:`2015-4004`, :cve:`2015-4036`, :cve:`2015-4167`, :cve:`2015-4170`, :cve:`2015-4176`, :cve:`2015-4177`, :cve:`2015-4178`, :cve:`2015-4692`, :cve:`2015-4700`, :cve:`2015-5156`, :cve:`2015-5157`, :cve:`2015-5257`, :cve:`2015-5283`, :cve:`2015-5307`, :cve:`2015-5327`, :cve:`2015-5364`, :cve:`2015-5366`, :cve:`2015-5697`, :cve:`2015-5706`, :cve:`2015-5707`, :cve:`2015-6252`, :cve:`2015-6526`, :cve:`2015-6937`, :cve:`2015-7509`, :cve:`2015-7513`, :cve:`2015-7515`, :cve:`2015-7550`, :cve:`2015-7566`, :cve:`2015-7613`, :cve:`2015-7799`, :cve:`2015-7833`, :cve:`2015-7872`, :cve:`2015-7884`, :cve:`2015-7885`, :cve:`2015-7990`, :cve:`2015-8104`, :cve:`2015-8215`, :cve:`2015-8324`, :cve:`2015-8374`, :cve:`2015-8539`, :cve:`2015-8543`, :cve:`2015-8550`, :cve:`2015-8551`, :cve:`2015-8552`, :cve:`2015-8553`, :cve:`2015-8569`, :cve:`2015-8575`, :cve:`2015-8660`, :cve:`2015-8709`, :cve:`2015-8746`, :cve:`2015-8767`, :cve:`2015-8785`, :cve:`2015-8787`, :cve:`2015-8812`, :cve:`2015-8816`, :cve:`2015-8830`, :cve:`2015-8839`, :cve:`2015-8844`, :cve:`2015-8845`, :cve:`2015-8950`, :cve:`2015-8952`, :cve:`2015-8953`, :cve:`2015-8955`, :cve:`2015-8956`, :cve:`2015-8961`, :cve:`2015-8962`, :cve:`2015-8963`, :cve:`2015-8964`, :cve:`2015-8966`, :cve:`2015-8967`, :cve:`2015-8970`, :cve:`2015-9004`, :cve:`2015-9016`, :cve:`2015-9289`, :cve:`2016-0617`, :cve:`2016-0723`, :cve:`2016-0728`, :cve:`2016-0758`, :cve:`2016-0821`, :cve:`2016-0823`, :cve:`2016-10044`, :cve:`2016-10088`, :cve:`2016-10147`, :cve:`2016-10150`, :cve:`2016-10153`, :cve:`2016-10154`, :cve:`2016-10200`, :cve:`2016-10208`, :cve:`2016-10229`, :cve:`2016-10318`, :cve:`2016-10723`, :cve:`2016-10741`, :cve:`2016-10764`, :cve:`2016-10905`, :cve:`2016-10906`, :cve:`2016-10907`, :cve:`2016-1237`, :cve:`2016-1575`, :cve:`2016-1576`, :cve:`2016-1583`, :cve:`2016-2053`, :cve:`2016-2069`, :cve:`2016-2070`, :cve:`2016-2085`, :cve:`2016-2117`, :cve:`2016-2143`, :cve:`2016-2184`, :cve:`2016-2185`, :cve:`2016-2186`, :cve:`2016-2187`, :cve:`2016-2188`, :cve:`2016-2383`, :cve:`2016-2384`, :cve:`2016-2543`, :cve:`2016-2544`, :cve:`2016-2545`, :cve:`2016-2546`, :cve:`2016-2547`, :cve:`2016-2548`, :cve:`2016-2549`, :cve:`2016-2550`, :cve:`2016-2782`, :cve:`2016-2847`, :cve:`2016-3044`, :cve:`2016-3070`, :cve:`2016-3134`, :cve:`2016-3135`, :cve:`2016-3136`, :cve:`2016-3137`, :cve:`2016-3138`, :cve:`2016-3139`, :cve:`2016-3140`, :cve:`2016-3156`, :cve:`2016-3157`, :cve:`2016-3672`, :cve:`2016-3689`, :cve:`2016-3713`, :cve:`2016-3841`, :cve:`2016-3857`, :cve:`2016-3951`, :cve:`2016-3955`, :cve:`2016-3961`, :cve:`2016-4440`, :cve:`2016-4470`, :cve:`2016-4482`, :cve:`2016-4485`, :cve:`2016-4486`, :cve:`2016-4557`, :cve:`2016-4558`, :cve:`2016-4565`, :cve:`2016-4568`, :cve:`2016-4569`, :cve:`2016-4578`, :cve:`2016-4580`, :cve:`2016-4581`, :cve:`2016-4794`, :cve:`2016-4805`, :cve:`2016-4913`, :cve:`2016-4951`, :cve:`2016-4997`, :cve:`2016-4998`, :cve:`2016-5195`, :cve:`2016-5243`, :cve:`2016-5244`, :cve:`2016-5400`, :cve:`2016-5412`, :cve:`2016-5696`, :cve:`2016-5728`, :cve:`2016-5828`, :cve:`2016-5829`, :cve:`2016-6130`, :cve:`2016-6136`, :cve:`2016-6156`, :cve:`2016-6162`, :cve:`2016-6187`, :cve:`2016-6197`, :cve:`2016-6198`, :cve:`2016-6213`, :cve:`2016-6327`, :cve:`2016-6480`, :cve:`2016-6516`, :cve:`2016-6786`, :cve:`2016-6787`, :cve:`2016-6828`, :cve:`2016-7039`, :cve:`2016-7042`, :cve:`2016-7097`, :cve:`2016-7117`, :cve:`2016-7425`, :cve:`2016-7910`, :cve:`2016-7911`, :cve:`2016-7912`, :cve:`2016-7913`, :cve:`2016-7914`, :cve:`2016-7915`, :cve:`2016-7916`, :cve:`2016-7917`, :cve:`2016-8399`, :cve:`2016-8405`, :cve:`2016-8630`, :cve:`2016-8632`, :cve:`2016-8633`, :cve:`2016-8636`, :cve:`2016-8645`, :cve:`2016-8646`, :cve:`2016-8650`, :cve:`2016-8655`, :cve:`2016-8658`, :cve:`2016-8666`, :cve:`2016-9083`, :cve:`2016-9084`, :cve:`2016-9120`, :cve:`2016-9178`, :cve:`2016-9191`, :cve:`2016-9313`, :cve:`2016-9555`, :cve:`2016-9576`, :cve:`2016-9588`, :cve:`2016-9604`, :cve:`2016-9685`, :cve:`2016-9754`, :cve:`2016-9755`, :cve:`2016-9756`, :cve:`2016-9777`, :cve:`2016-9793`, :cve:`2016-9794`, :cve:`2016-9806`, :cve:`2016-9919`, :cve:`2017-0605`, :cve:`2017-0627`, :cve:`2017-0750`, :cve:`2017-0786`, :cve:`2017-0861`, :cve:`2017-1000`, :cve:`2017-1000111`, :cve:`2017-1000112`, :cve:`2017-1000251`, :cve:`2017-1000252`, :cve:`2017-1000253`, :cve:`2017-1000255`, :cve:`2017-1000363`, :cve:`2017-1000364`, :cve:`2017-1000365`, :cve:`2017-1000370`, :cve:`2017-1000371`, :cve:`2017-1000379`, :cve:`2017-1000380`, :cve:`2017-1000405`, :cve:`2017-1000407`, :cve:`2017-1000410`, :cve:`2017-10661`, :cve:`2017-10662`, :cve:`2017-10663`, :cve:`2017-10810`, :cve:`2017-10911`, :cve:`2017-11089`, :cve:`2017-11176`, :cve:`2017-11472`, :cve:`2017-11473`, :cve:`2017-11600`, :cve:`2017-12134`, :cve:`2017-12146`, :cve:`2017-12153`, :cve:`2017-12154`, :cve:`2017-12168`, :cve:`2017-12188`, :cve:`2017-12190`, :cve:`2017-12192`, :cve:`2017-12193`, :cve:`2017-12762`, :cve:`2017-13080`, :cve:`2017-13166`, :cve:`2017-13167`, :cve:`2017-13168`, :cve:`2017-13215`, :cve:`2017-13216`, :cve:`2017-13220`, :cve:`2017-13305`, :cve:`2017-13686`, :cve:`2017-13695`, :cve:`2017-13715`, :cve:`2017-14051`, :cve:`2017-14106`, :cve:`2017-14140`, :cve:`2017-14156`, :cve:`2017-14340`, :cve:`2017-14489`, :cve:`2017-14497`, :cve:`2017-14954`, :cve:`2017-14991`, :cve:`2017-15102`, :cve:`2017-15115`, :cve:`2017-15116`, :cve:`2017-15121`, :cve:`2017-15126`, :cve:`2017-15127`, :cve:`2017-15128`, :cve:`2017-15129`, :cve:`2017-15265`, :cve:`2017-15274`, :cve:`2017-15299`, :cve:`2017-15306`, :cve:`2017-15537`, :cve:`2017-15649`, :cve:`2017-15868`, :cve:`2017-15951`, :cve:`2017-16525`, :cve:`2017-16526`, :cve:`2017-16527`, :cve:`2017-16528`, :cve:`2017-16529`, :cve:`2017-16530`, :cve:`2017-16531`, :cve:`2017-16532`, :cve:`2017-16533`, :cve:`2017-16534`, :cve:`2017-16535`, :cve:`2017-16536`, :cve:`2017-16537`, :cve:`2017-16538`, :cve:`2017-16643`, :cve:`2017-16644`, :cve:`2017-16645`, :cve:`2017-16646`, :cve:`2017-16647`, :cve:`2017-16648`, :cve:`2017-16649`, :cve:`2017-16650`, :cve:`2017-16911`, :cve:`2017-16912`, :cve:`2017-16913`, :cve:`2017-16914`, :cve:`2017-16939`, :cve:`2017-16994`, :cve:`2017-16995`, :cve:`2017-16996`, :cve:`2017-17052`, :cve:`2017-17053`, :cve:`2017-17448`, :cve:`2017-17449`, :cve:`2017-17450`, :cve:`2017-17558`, :cve:`2017-17712`, :cve:`2017-17741`, :cve:`2017-17805`, :cve:`2017-17806`, :cve:`2017-17807`, :cve:`2017-17852`, :cve:`2017-17853`, :cve:`2017-17854`, :cve:`2017-17855`, :cve:`2017-17856`, :cve:`2017-17857`, :cve:`2017-17862`, :cve:`2017-17863`, :cve:`2017-17864`, :cve:`2017-17975`, :cve:`2017-18017`, :cve:`2017-18075`, :cve:`2017-18079`, :cve:`2017-18174`, :cve:`2017-18193`, :cve:`2017-18200`, :cve:`2017-18202`, :cve:`2017-18203`, :cve:`2017-18204`, :cve:`2017-18208`, :cve:`2017-18216`, :cve:`2017-18218`, :cve:`2017-18221`, :cve:`2017-18222`, :cve:`2017-18224`, :cve:`2017-18232`, :cve:`2017-18241`, :cve:`2017-18249`, :cve:`2017-18255`, :cve:`2017-18257`, :cve:`2017-18261`, :cve:`2017-18270`, :cve:`2017-18344`, :cve:`2017-18360`, :cve:`2017-18379`, :cve:`2017-18509`, :cve:`2017-18549`, :cve:`2017-18550`, :cve:`2017-18551`, :cve:`2017-18552`, :cve:`2017-18595`, :cve:`2017-2583`, :cve:`2017-2584`, :cve:`2017-2596`, :cve:`2017-2618`, :cve:`2017-2634`, :cve:`2017-2636`, :cve:`2017-2647`, :cve:`2017-2671`, :cve:`2017-5123`, :cve:`2017-5546`, :cve:`2017-5547`, :cve:`2017-5548`, :cve:`2017-5549`, :cve:`2017-5550`, :cve:`2017-5551`, :cve:`2017-5576`, :cve:`2017-5577`, :cve:`2017-5669`, :cve:`2017-5715`, :cve:`2017-5753`, :cve:`2017-5754`, :cve:`2017-5897`, :cve:`2017-5967`, :cve:`2017-5970`, :cve:`2017-5972`, :cve:`2017-5986`, :cve:`2017-6001`, :cve:`2017-6074`, :cve:`2017-6214`, :cve:`2017-6345`, :cve:`2017-6346`, :cve:`2017-6347`, :cve:`2017-6348`, :cve:`2017-6353`, :cve:`2017-6874`, :cve:`2017-6951`, :cve:`2017-7184`, :cve:`2017-7187`, :cve:`2017-7261`, :cve:`2017-7273`, :cve:`2017-7277`, :cve:`2017-7294`, :cve:`2017-7308`, :cve:`2017-7346`, :cve:`2017-7374`, :cve:`2017-7472`, :cve:`2017-7477`, :cve:`2017-7482`, :cve:`2017-7487`, :cve:`2017-7495`, :cve:`2017-7518`, :cve:`2017-7533`, :cve:`2017-7541`, :cve:`2017-7542`, :cve:`2017-7558`, :cve:`2017-7616`, :cve:`2017-7618`, :cve:`2017-7645`, :cve:`2017-7889`, :cve:`2017-7895`, :cve:`2017-7979`, :cve:`2017-8061`, :cve:`2017-8062`, :cve:`2017-8063`, :cve:`2017-8064`, :cve:`2017-8065`, :cve:`2017-8066`, :cve:`2017-8067`, :cve:`2017-8068`, :cve:`2017-8069`, :cve:`2017-8070`, :cve:`2017-8071`, :cve:`2017-8072`, :cve:`2017-8106`, :cve:`2017-8240`, :cve:`2017-8797`, :cve:`2017-8824`, :cve:`2017-8831`, :cve:`2017-8890`, :cve:`2017-8924`, :cve:`2017-8925`, :cve:`2017-9059`, :cve:`2017-9074`, :cve:`2017-9075`, :cve:`2017-9076`, :cve:`2017-9077`, :cve:`2017-9150`, :cve:`2017-9211`, :cve:`2017-9242`, :cve:`2017-9605`, :cve:`2017-9725`, :cve:`2017-9984`, :cve:`2017-9985`, :cve:`2017-9986`, :cve:`2018-1000004`, :cve:`2018-1000026`, :cve:`2018-1000028`, :cve:`2018-1000199`, :cve:`2018-1000200`, :cve:`2018-1000204`, :cve:`2018-10021`, :cve:`2018-10074`, :cve:`2018-10087`, :cve:`2018-10124`, :cve:`2018-10322`, :cve:`2018-10323`, :cve:`2018-1065`, :cve:`2018-1066`, :cve:`2018-10675`, :cve:`2018-1068`, :cve:`2018-10840`, :cve:`2018-10853`, :cve:`2018-1087`, :cve:`2018-10876`, :cve:`2018-10877`, :cve:`2018-10878`, :cve:`2018-10879`, :cve:`2018-10880`, :cve:`2018-10881`, :cve:`2018-10882`, :cve:`2018-10883`, :cve:`2018-10901`, :cve:`2018-10902`, :cve:`2018-1091`, :cve:`2018-1092`, :cve:`2018-1093`, :cve:`2018-10938`, :cve:`2018-1094`, :cve:`2018-10940`, :cve:`2018-1095`, :cve:`2018-1108`, :cve:`2018-1118`, :cve:`2018-1120`, :cve:`2018-11232`, :cve:`2018-1128`, :cve:`2018-1129`, :cve:`2018-1130`, :cve:`2018-11412`, :cve:`2018-11506`, :cve:`2018-11508`, :cve:`2018-12126`, :cve:`2018-12127`, :cve:`2018-12130`, :cve:`2018-12207`, :cve:`2018-12232`, :cve:`2018-12233`, :cve:`2018-12633`, :cve:`2018-12714`, :cve:`2018-12896`, :cve:`2018-12904`, :cve:`2018-13053`, :cve:`2018-13093`, :cve:`2018-13094`, :cve:`2018-13095`, :cve:`2018-13096`, :cve:`2018-13097`, :cve:`2018-13098`, :cve:`2018-13099`, :cve:`2018-13100`, :cve:`2018-13405`, :cve:`2018-13406`, :cve:`2018-14609`, :cve:`2018-14610`, :cve:`2018-14611`, :cve:`2018-14612`, :cve:`2018-14613`, :cve:`2018-14614`, :cve:`2018-14615`, :cve:`2018-14616`, :cve:`2018-14617`, :cve:`2018-14619`, :cve:`2018-14625`, :cve:`2018-14633`, :cve:`2018-14634`, :cve:`2018-14641`, :cve:`2018-14646`, :cve:`2018-14656`, :cve:`2018-14678`, :cve:`2018-14734`, :cve:`2018-15471`, :cve:`2018-15572`, :cve:`2018-15594`, :cve:`2018-16276`, :cve:`2018-16597`, :cve:`2018-16658`, :cve:`2018-16862`, :cve:`2018-16871`, :cve:`2018-16880`, :cve:`2018-16882`, :cve:`2018-16884`, :cve:`2018-17182`, :cve:`2018-17972`, :cve:`2018-18021`, :cve:`2018-18281`, :cve:`2018-18386`, :cve:`2018-18397`, :cve:`2018-18445`, :cve:`2018-18559`, :cve:`2018-18690`, :cve:`2018-18710`, :cve:`2018-18955`, :cve:`2018-19406`, :cve:`2018-19407`, :cve:`2018-19824`, :cve:`2018-19854`, :cve:`2018-19985`, :cve:`2018-20169`, :cve:`2018-20449`, :cve:`2018-20509`, :cve:`2018-20510`, :cve:`2018-20511`, :cve:`2018-20669`, :cve:`2018-20784`, :cve:`2018-20836`, :cve:`2018-20854`, :cve:`2018-20855`, :cve:`2018-20856`, :cve:`2018-20961`, :cve:`2018-20976`, :cve:`2018-21008`, :cve:`2018-25015`, :cve:`2018-25020`, :cve:`2018-3620`, :cve:`2018-3639`, :cve:`2018-3646`, :cve:`2018-3665`, :cve:`2018-3693`, :cve:`2018-5332`, :cve:`2018-5333`, :cve:`2018-5344`, :cve:`2018-5390`, :cve:`2018-5391`, :cve:`2018-5703`, :cve:`2018-5750`, :cve:`2018-5803`, :cve:`2018-5814`, :cve:`2018-5848`, :cve:`2018-5873`, :cve:`2018-5953`, :cve:`2018-5995`, :cve:`2018-6412`, :cve:`2018-6554`, :cve:`2018-6555`, :cve:`2018-6927`, :cve:`2018-7191`, :cve:`2018-7273`, :cve:`2018-7480`, :cve:`2018-7492`, :cve:`2018-7566`, :cve:`2018-7740`, :cve:`2018-7754`, :cve:`2018-7755`, :cve:`2018-7757`, :cve:`2018-7995`, :cve:`2018-8043`, :cve:`2018-8087`, :cve:`2018-8781`, :cve:`2018-8822`, :cve:`2018-8897`, :cve:`2018-9363`, :cve:`2018-9385`, :cve:`2018-9415`, :cve:`2018-9422`, :cve:`2018-9465`, :cve:`2018-9516`, :cve:`2018-9517`, :cve:`2018-9518`, :cve:`2018-9568`, :cve:`2019-0136`, :cve:`2019-0145`, :cve:`2019-0146`, :cve:`2019-0147`, :cve:`2019-0148`, :cve:`2019-0149`, :cve:`2019-0154`, :cve:`2019-0155`, :cve:`2019-10124`, :cve:`2019-10125`, :cve:`2019-10126`, :cve:`2019-10142`, :cve:`2019-10207`, :cve:`2019-10220`, :cve:`2019-10638`, :cve:`2019-10639`, :cve:`2019-11085`, :cve:`2019-11091`, :cve:`2019-11135`, :cve:`2019-11190`, :cve:`2019-11191`, :cve:`2019-1125`, :cve:`2019-11477`, :cve:`2019-11478`, :cve:`2019-11479`, :cve:`2019-11486`, :cve:`2019-11487`, :cve:`2019-11599`, :cve:`2019-11683`, :cve:`2019-11810`, :cve:`2019-11811`, :cve:`2019-11815`, :cve:`2019-11833`, :cve:`2019-11884`, :cve:`2019-12378`, :cve:`2019-12379`, :cve:`2019-12380`, :cve:`2019-12381`, :cve:`2019-12382`, :cve:`2019-12454`, :cve:`2019-12455`, :cve:`2019-12614`, :cve:`2019-12615`, :cve:`2019-12817`, :cve:`2019-12818`, :cve:`2019-12819`, :cve:`2019-12881`, :cve:`2019-12984`, :cve:`2019-13233`, :cve:`2019-13272`, :cve:`2019-13631`, :cve:`2019-13648`, :cve:`2019-14283`, :cve:`2019-14284`, :cve:`2019-14615`, :cve:`2019-14763`, :cve:`2019-14814`, :cve:`2019-14815`, :cve:`2019-14816`, :cve:`2019-14821`, :cve:`2019-14835`, :cve:`2019-14895`, :cve:`2019-14896`, :cve:`2019-14897`, :cve:`2019-14901`, :cve:`2019-15030`, :cve:`2019-15031`, :cve:`2019-15090`, :cve:`2019-15098`, :cve:`2019-15099`, :cve:`2019-15117`, :cve:`2019-15118`, :cve:`2019-15211`, :cve:`2019-15212`, :cve:`2019-15213`, :cve:`2019-15214`, :cve:`2019-15215`, :cve:`2019-15216`, :cve:`2019-15217`, :cve:`2019-15218`, :cve:`2019-15219`, :cve:`2019-15220`, :cve:`2019-15221`, :cve:`2019-15222`, :cve:`2019-15223`, :cve:`2019-15291`, :cve:`2019-15292`, :cve:`2019-15504`, :cve:`2019-15505`, :cve:`2019-15538`, :cve:`2019-15666`, :cve:`2019-15794`, :cve:`2019-15807`, :cve:`2019-15916`, :cve:`2019-15917`, :cve:`2019-15918`, :cve:`2019-15919`, :cve:`2019-15920`, :cve:`2019-15921`, :cve:`2019-15922`, :cve:`2019-15923`, :cve:`2019-15924`, :cve:`2019-15925`, :cve:`2019-15926`, :cve:`2019-15927`, :cve:`2019-16229`, :cve:`2019-16230`, :cve:`2019-16231`, :cve:`2019-16232`, :cve:`2019-16233`, :cve:`2019-16234`, :cve:`2019-16413`, :cve:`2019-16714`, :cve:`2019-16746`, :cve:`2019-16921`, :cve:`2019-16994`, :cve:`2019-16995`, :cve:`2019-17052`, :cve:`2019-17053`, :cve:`2019-17054`, :cve:`2019-17055`, :cve:`2019-17056`, :cve:`2019-17075`, :cve:`2019-17133`, :cve:`2019-17351`, :cve:`2019-17666`, :cve:`2019-18198`, :cve:`2019-18282`, :cve:`2019-18660`, :cve:`2019-18675`, :cve:`2019-18683`, :cve:`2019-18786`, :cve:`2019-18805`, :cve:`2019-18806`, :cve:`2019-18807`, :cve:`2019-18808`, :cve:`2019-18809`, :cve:`2019-18810`, :cve:`2019-18811`, :cve:`2019-18812`, :cve:`2019-18813`, :cve:`2019-18814`, :cve:`2019-18885`, :cve:`2019-19036`, :cve:`2019-19037`, :cve:`2019-19039`, :cve:`2019-19043`, :cve:`2019-19044`, :cve:`2019-19045`, :cve:`2019-19046`, :cve:`2019-19047`, :cve:`2019-19048`, :cve:`2019-19049`, :cve:`2019-19050`, :cve:`2019-19051`, :cve:`2019-19052`, :cve:`2019-19053`, :cve:`2019-19054`, :cve:`2019-19055`, :cve:`2019-19056`, :cve:`2019-19057`, :cve:`2019-19058`, :cve:`2019-19059`, :cve:`2019-19060`, :cve:`2019-19061`, :cve:`2019-19062`, :cve:`2019-19063`, :cve:`2019-19064`, :cve:`2019-19065`, :cve:`2019-19066`, :cve:`2019-19067`, :cve:`2019-19068`, :cve:`2019-19069`, :cve:`2019-19070`, :cve:`2019-19071`, :cve:`2019-19072`, :cve:`2019-19073`, :cve:`2019-19074`, :cve:`2019-19075`, :cve:`2019-19076`, :cve:`2019-19077`, :cve:`2019-19078`, :cve:`2019-19079`, :cve:`2019-19080`, :cve:`2019-19081`, :cve:`2019-19082`, :cve:`2019-19083`, :cve:`2019-19227`, :cve:`2019-19241`, :cve:`2019-19252`, :cve:`2019-19318`, :cve:`2019-19319`, :cve:`2019-19332`, :cve:`2019-19338`, :cve:`2019-19377`, :cve:`2019-19447`, :cve:`2019-19448`, :cve:`2019-19449`, :cve:`2019-19462`, :cve:`2019-19523`, :cve:`2019-19524`, :cve:`2019-19525`, :cve:`2019-19526`, :cve:`2019-19527`, :cve:`2019-19528`, :cve:`2019-19529`, :cve:`2019-19530`, :cve:`2019-19531`, :cve:`2019-19532`, :cve:`2019-19533`, :cve:`2019-19534`, :cve:`2019-19535`, :cve:`2019-19536`, :cve:`2019-19537`, :cve:`2019-19543`, :cve:`2019-19602`, :cve:`2019-19767`, :cve:`2019-19768`, :cve:`2019-19769`, :cve:`2019-19770`, :cve:`2019-19807`, :cve:`2019-19813`, :cve:`2019-19815`, :cve:`2019-19816`, :cve:`2019-19922`, :cve:`2019-19927`, :cve:`2019-19947`, :cve:`2019-19965` and :cve:`2019-1999`
-  nasm: Fix :cve:`2020-21528`
-  ncurses: Fix :cve:`2023-29491`
-  nghttp2: Fix :cve:`2023-35945`
-  procps: Fix :cve:`2023-4016`
-  python3-certifi: Fix :cve:`2023-37920`
-  python3-git: Fix :cve:`2022-24439` and :cve:`2023-40267`
-  python3-pygments: Fix :cve:`2022-40896`
-  python3: Fix :cve:`2023-40217`
-  qemu: Fix :cve:`2020-14394`, :cve:`2021-3638`, :cve_mitre:`2023-2861`, :cve:`2023-3180` and :cve:`2023-3354`
-  tiff: fix :cve:`2023-2908`, :cve:`2023-3316` and :cve:`2023-3618`
-  vim: Fix :cve:`2023-3896`, :cve:`2023-4733`, :cve:`2023-4734`, :cve:`2023-4735`, :cve:`2023-4736`, :cve:`2023-4738`, :cve:`2023-4750` and :cve:`2023-4752`
-  webkitgtk: fix :cve:`2022-48503` and :cve:`2023-23529`



Fixes in Yocto-4.0.13
~~~~~~~~~~~~~~~~~~~~~

-  acl/attr: ptest fixes and improvements
-  automake: fix buildtest patch
-  bind: Upgrade to 9.18.17
-  binutils: stable 2.38 branch updates
-  build-appliance-image: Update to kirkstone head revision
-  build-sysroots: Add :term:`SUMMARY` field
-  cargo.bbclass: set up cargo environment in common do_compile
-  contributor-guide: recipe-style-guide: add Upstream-Status
-  dbus: Specify runstatedir configure option
-  dev-manual: common-tasks: mention faster "find" command to trim sstate cache
-  dev-manual: disk-space: improve wording for obsolete sstate cache files
-  dev-manual: licenses: mention :term:`SPDX` for license compliance
-  dev-manual: licenses: update license manifest location
-  dev-manual: new-recipe.rst fix inconsistency with contributor guide
-  dev-manual: split common-tasks.rst
-  dev-manual: wic.rst: Update native tools build command
-  documentation/README: align with master
-  efivar: backport 5 patches to fix build with gold
-  externalsrc: fix dependency chain issues
-  glibc-locale: use stricter matching for metapackages' runtime dependencies
-  glibc/check-test-wrapper: don't emit warnings from ssh
-  glibc: stable 2.35 branch updates
-  gst-devtools: Upgrade to 1.20.7
-  gstreamer1.0-libav: Upgrade to 1.20.7
-  gstreamer1.0-omx: Upgrade to 1.20.7
-  gstreamer1.0-plugins-bad: Upgrade to 1.20.7
-  gstreamer1.0-plugins-base: Upgrade to 1.20.7
-  gstreamer1.0-plugins-good: Upgrade to 1.20.7
-  gstreamer1.0-plugins-ugly: Upgrade to 1.20.7
-  gstreamer1.0-python: Upgrade to 1.20.7
-  gstreamer1.0-rtsp-server: Upgrade to 1.20.7
-  gstreamer1.0-vaapi: Upgrade to 1.20.7
-  gstreamer1.0: Upgrade to 1.20.7
-  kernel: Fix path comparison in kernel staging dir symlinking
-  lib/package_manager: Improve repo artefact filtering
-  libdnf: resolve cstdint inclusion for newer gcc versions
-  libnss-nis: Upgrade to 3.2
-  librsvg: Upgrade to 2.52.10
-  libxcrypt: update :term:`PV` to match :term:`SRCREV`
-  linux-firmware : Add firmware of RTL8822 serie
-  linux-firmware: Fix mediatek mt7601u firmware path
-  linux-firmware: package firmware for Dragonboard 410c
-  linux-firmware: split platform-specific Adreno shaders to separate packages
-  linux-firmware: Upgrade to 20230625
-  linux-yocto/5.10: update to v5.10.188
-  linux-yocto/5.15: update to v5.15.124
-  linux-yocto: add script to generate kernel :term:`CVE_CHECK_IGNORE` entries
-  linux/cve-exclusion: add generated CVE_CHECK_IGNORES.
-  linux/cve-exclusion: remove obsolete manual entries
-  manuals: add new contributor guide
-  manuals: document "mime-xdg" class and :term:`MIME_XDG_PACKAGES`
-  manuals: update former references to dev-manual/common-tasks
-  mdadm: add util-linux-blockdev ptest dependency
-  migration-guides: add release notes for 4.0.12
-  npm.bbclass: avoid DeprecationWarning with new python
-  oeqa/runtime/ltp: Increase ltp test output timeout
-  oeqa/ssh: Further improve process exit handling
-  oeqa/target/ssh: Ensure EAGAIN doesn't truncate output
-  oeqa/utils/nfs: allow requesting non-udp ports
-  pixman: Remove duplication of license MIT
-  poky.conf: bump version for 4.0.13
-  poky.conf: update :term:`SANITY_TESTED_DISTROS` to match autobuilder
-  pseudo: Fix to work with glibc 2.38
-  python3-git: Upgrade to 3.1.32
-  python3: upgrade to 3.10.13
-  ref-manual: add Initramfs term
-  ref-manual: add meson class and variables
-  ref-manual: add new variables
-  ref-manual: qa-checks: align with master
-  ref-manual: system-requirements: update supported distros
-  resulttool/report: Avoid divide by zero
-  resulttool/resultutils: allow index generation despite corrupt json
-  rootfs: Add debugfs package db file copy and cleanup
-  rpm2cpio.sh: update to the last 4.x version
-  rpm: Pick debugfs package db files/dirs explicitly
-  scripts/create-pull-request: update URLs to git repositories
-  scripts/rpm2cpio.sh: Use bzip2 instead of bunzip2
-  sdk-manual: extensible.rst: align with master branch
-  selftest/cases/glibc.py: fix the override syntax
-  selftest/cases/glibc.py: increase the memory for testing
-  selftest/cases/glibc.py: switch to using NFS over TCP
-  shadow-sysroot: add license information
-  sysklogd: fix integration with systemd-journald
-  tar: Upgrade to 1.35
-  target/ssh: Ensure exit code set for commands
-  tcl: prevent installing another copy of tzdata
-  template: fix typo in section header
-  vim: Upgrade to 9.0.1894
-  vim: update obsolete comment
-  wic: fix wrong attempt to create file system in unpartitioned regions
-  yocto-uninative: Update to 4.2 for glibc 2.38
-  yocto-uninative: Update to 4.3


Known Issues in Yocto-4.0.13
~~~~~~~~~~~~~~~~~~~~~~~~~~~~

- N/A


Contributors to Yocto-4.0.13
~~~~~~~~~~~~~~~~~~~~~~~~~~~~

-  Abe Kohandel
-  Adrian Freihofer
-  Alberto Planas
-  Alex Kiernan
-  Alexander Kanavin
-  Alexis Lothoré
-  Anuj Mittal
-  Archana Polampalli
-  Ashish Sharma
-  BELOUARGA Mohamed
-  Bruce Ashfield
-  Changqing Li
-  Dmitry Baryshkov
-  Enrico Scholz
-  Etienne Cordonnier
-  Hitendra Prajapati
-  Julien Stephan
-  Kai Kang
-  Khem Raj
-  Lee Chee Yang
-  Marek Vasut
-  Markus Niebel
-  Martin Jansa
-  Meenali Gupta
-  Michael Halstead
-  Michael Opdenacker
-  Narpat Mali
-  Ovidiu Panait
-  Pavel Zhukov
-  Peter Marko
-  Peter Suti
-  Poonam Jadhav
-  Richard Purdie
-  Roland Hieber
-  Ross Burton
-  Sanjana
-  Siddharth Doshi
-  Soumya Sambu
-  Staffan Rydén
-  Steve Sakoman
-  Trevor Gamblin
-  Vijay Anusuri
-  Vivek Kumbhar
-  Wang Mingyu
-  Yogita Urade


Repositories / Downloads for Yocto-4.0.13
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

poky

-  Repository Location: :yocto_git:`/poky`
-  Branch: :yocto_git:`kirkstone </poky/log/?h=kirkstone>`
-  Tag:  :yocto_git:`yocto-4.0.13 </poky/log/?h=yocto-4.0.13>`
-  Git Revision: :yocto_git:`e51bf557f596c4da38789a948a3228ba11455e3c </poky/commit/?id=e51bf557f596c4da38789a948a3228ba11455e3c>`
-  Release Artefact: poky-e51bf557f596c4da38789a948a3228ba11455e3c
-  sha: afddadb367a90154751f04993077bceffdc1413f9ba9b8c03acb487d0437286e
-  Download Locations:
   http://downloads.yoctoproject.org/releases/yocto/yocto-4.0.13/poky-e51bf557f596c4da38789a948a3228ba11455e3c.tar.bz2
   http://mirrors.kernel.org/yocto/yocto/yocto-4.0.13/poky-e51bf557f596c4da38789a948a3228ba11455e3c.tar.bz2

openembedded-core

-  Repository Location: :oe_git:`/openembedded-core`
-  Branch: :oe_git:`kirkstone </openembedded-core/log/?h=kirkstone>`
-  Tag:  :oe_git:`yocto-4.0.13 </openembedded-core/log/?h=yocto-4.0.13>`
-  Git Revision: :oe_git:`d90e4d5e3cca9cffe8f60841afc63667a9ac39fa </openembedded-core/commit/?id=d90e4d5e3cca9cffe8f60841afc63667a9ac39fa>`
-  Release Artefact: oecore-d90e4d5e3cca9cffe8f60841afc63667a9ac39fa
-  sha: 56e3bdac81b3628e74dfef2132a54be4db7d87373139a00ed64f5c9a354d716a
-  Download Locations:
   http://downloads.yoctoproject.org/releases/yocto/yocto-4.0.13/oecore-d90e4d5e3cca9cffe8f60841afc63667a9ac39fa.tar.bz2
   http://mirrors.kernel.org/yocto/yocto/yocto-4.0.13/oecore-d90e4d5e3cca9cffe8f60841afc63667a9ac39fa.tar.bz2

meta-mingw

-  Repository Location: :yocto_git:`/meta-mingw`
-  Branch: :yocto_git:`kirkstone </meta-mingw/log/?h=kirkstone>`
-  Tag:  :yocto_git:`yocto-4.0.13 </meta-mingw/log/?h=yocto-4.0.13>`
-  Git Revision: :yocto_git:`a90614a6498c3345704e9611f2842eb933dc51c1 </meta-mingw/commit/?id=a90614a6498c3345704e9611f2842eb933dc51c1>`
-  Release Artefact: meta-mingw-a90614a6498c3345704e9611f2842eb933dc51c1
-  sha: 49f9900bfbbc1c68136f8115b314e95d0b7f6be75edf36a75d9bcd1cca7c6302
-  Download Locations:
   http://downloads.yoctoproject.org/releases/yocto/yocto-4.0.13/meta-mingw-a90614a6498c3345704e9611f2842eb933dc51c1.tar.bz2
   http://mirrors.kernel.org/yocto/yocto/yocto-4.0.13/meta-mingw-a90614a6498c3345704e9611f2842eb933dc51c1.tar.bz2

meta-gplv2

-  Repository Location: :yocto_git:`/meta-gplv2`
-  Branch: :yocto_git:`kirkstone </meta-gplv2/log/?h=kirkstone>`
-  Tag:  :yocto_git:`yocto-4.0.13 </meta-gplv2/log/?h=yocto-4.0.13>`
-  Git Revision: :yocto_git:`d2f8b5cdb285b72a4ed93450f6703ca27aa42e8a </meta-gplv2/commit/?id=d2f8b5cdb285b72a4ed93450f6703ca27aa42e8a>`
-  Release Artefact: meta-gplv2-d2f8b5cdb285b72a4ed93450f6703ca27aa42e8a
-  sha: c386f59f8a672747dc3d0be1d4234b6039273d0e57933eb87caa20f56b9cca6d
-  Download Locations:
   http://downloads.yoctoproject.org/releases/yocto/yocto-4.0.13/meta-gplv2-d2f8b5cdb285b72a4ed93450f6703ca27aa42e8a.tar.bz2
   http://mirrors.kernel.org/yocto/yocto/yocto-4.0.13/meta-gplv2-d2f8b5cdb285b72a4ed93450f6703ca27aa42e8a.tar.bz2

bitbake

-  Repository Location: :oe_git:`/bitbake`
-  Branch: :oe_git:`2.0 </bitbake/log/?h=2.0>`
-  Tag:  :oe_git:`yocto-4.0.13 </bitbake/log/?h=yocto-4.0.13>`
-  Git Revision: :oe_git:`41b6684489d0261753344956042be2cc4adb0159 </bitbake/commit/?id=41b6684489d0261753344956042be2cc4adb0159>`
-  Release Artefact: bitbake-41b6684489d0261753344956042be2cc4adb0159
-  sha: efa2b1c4d0be115ed3960750d1e4ed958771b2db6d7baee2d13ad386589376e8
-  Download Locations:
   http://downloads.yoctoproject.org/releases/yocto/yocto-4.0.13/bitbake-41b6684489d0261753344956042be2cc4adb0159.tar.bz2
   http://mirrors.kernel.org/yocto/yocto/yocto-4.0.13/bitbake-41b6684489d0261753344956042be2cc4adb0159.tar.bz2

yocto-docs

-  Repository Location: :yocto_git:`/yocto-docs`
-  Branch: :yocto_git:`kirkstone </yocto-docs/log/?h=kirkstone>`
-  Tag: :yocto_git:`yocto-4.0.13 </yocto-docs/log/?h=yocto-4.0.13>`
-  Git Revision: :yocto_git:`8f02741de867125f11a37822b2d206be180d4ee3 </yocto-docs/commit/?id=8f02741de867125f11a37822b2d206be180d4ee3>`

