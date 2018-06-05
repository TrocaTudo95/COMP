.class public aval4
.super java/lang/Object
.method public static f(II)I
.limit locals 3
.limit stack 3
loop0:
iload_0
iconst_-99
iload_1
if_icmpge loop0_end 
iconst_-99
invokestatic io/read()V
istore_2

iconst_-99
invokestatic io/read()V
istore_0

iconst_-99
iload_0
iconst_-99
iload_2
iadd
istore_0

goto loop0
loop0_end:
return
.end method
.method public static main([Ljava/lang/String;)V
.limit locals 1
.limit stack 1
iconst_-99
iconst_5
bipush 6
invokestatic aval4/f(II)I
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
