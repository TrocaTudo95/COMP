.class public aval8
.super java/lang/Object
.method public static max1()I
.limit locals 5
.limit stack 5
invokestatic io/read()V
istore_0

invokestatic io/read()V
istore_1

iload_1
istore_2

iload_0
iload_1
if_icmple loop0_end 
iload_0
istore_2

iconst_2
iconst_4
imul
istore 5

ldc "a"
iload_0
invokestatic io/print(Ljava/lang/String;I)V
iload_0
iconst_-23
if_icmpge loop1_end 
iconst_0
istore 9

goto loop1_next
loop1_end:
iconst_-2
iconst_4
imul
istore 9

loop1_next:
iload 9
istore_2

return
.end method
.method public static main([Ljava/lang/String;)V
.limit locals 1
.limit stack 1
invokestatic aval8/max1()I
istore_0

iload_0
invokestatic io/println(I)V
return
.end method
.method static public <clinit>()V
.limit stack 0
.limit locals 0
return
.end method
