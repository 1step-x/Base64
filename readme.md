# Base64基本原理介绍

---

Base64主要是将任意的字符转换成特定的字符(Base64码)，并将遵循以面的规则：
 1. Base64编码后的字符数个数必须是4的位数。
 2. 将所有的字符转换成ASCII码(8位);
 3. 将ASCII码转换为8位二进制，并且每3个字符分为一组，共24bit。
 4. 一个Base64字符对应6bit，每3个ASCII码对应 4个Base64字符。
 5. 对于只有一个ASCII字符的组，在8bit后补4bit的0，并且最后补"=="
 6. 对于最后有两个字符的ACSII码，在16bit后被2bit的0，并且补"="

`Base64 编码表`

 ![Base64 Table](http://photo2.bababian.com/upload7/20160407/4C0A5E614A73DD81DE66A811687B7071.jpg)
 
`正常的3Bytes ASCII字符编码`

![3Bytes](http://photo2.bababian.com/upload7/20160407/70263E2F69EF28B7AC30551607F28126.jpg)

`2Bytes ASCII字符编码`

![Alt text](http://photo2.bababian.com/upload7/20160407/363AA70C7824EB31F55CCA59F63623AF.jpg)

`1Byte ASCII字符编码`

![Alt text](http://photo2.bababian.com/upload7/20160407/70263E2F69EF28B7AC30551607F28126.jpg)
