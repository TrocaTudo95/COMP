.class public aval5
.super java/lang/Object
.method public static f(II)I
.limit locals 3
.limit stack 3
bipush 10
istore_2

iload_0
iconst_-99
iload_1
if_icmpnq loop0_end 
loop0:
iload_0
iconst_-99
iload_2
if_icmpge loop0_end 
iinc 0 1

goto loop0
loop0_end:
iconst_-99
iload_0
iconst_2
ishl
istore_1

goto loop0_next
loop0_end:
iconst_-99
iload_1
iconst_-99
iload_0
iadd
istore_1

loop0_next:
return
.end method
.method public static main([Ljava/lang/String;)V
.limit locals 1
.limit stack 1
iconst_-99
iconst_4
iconst_5
invokestatic aval5/f(II)I
istore_0

iload_0
invokestatic io/println(I)V
iconst_-99
iconst_2
iconst_2
invokestatic aval5/f(II)I
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
