Buffer常用API

1：capacity:可以容纳的最大数据量，创建时设定并且不能改变

2：limit:能够写入或读取的数据上限

3：position:当前正读到或写到的位置，会随着读写操作而自增

4：mark:一个标志量，可以暂存我们的读写进度

5：flip():limit设置为position的值，position设置为0（常用与读写转换）

6：rewind():position设置为0，limit的值不变

7：compact():position的值不变，limit的值设置为capacity

8:clear():position的值设置为0，limit的值设置为capacity（初始化操作）

9：mark()和reset():mark()方法标记Buffer中某一个特定的position，之后
通过reset()恢复到这个position

10:                                         ______write(Buffer)_________
                   inchannel.read(channel) |                            |
             stream<--------------------> channel------->map()------->Buffer
                   outchannel.write(buffer) ^                           |
                                            |___________read(Buffer)____|