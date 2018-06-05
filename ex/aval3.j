.class public aval3
.super java/lang/Object
.method public static f(II)I
.limit locals 3
.limit stack 3
iload_0
iconst_-99
iload_1
if_icmplt loop0_end 
iconst_2
istore_2

goto loop0_next
loop0_end:
iconst_4
istore_2

loop0_next:
return
.end method
.method public static main([Ljava/lang/String;)V
.limit locals 2
.limit stack 2
iconst_2
istore_0

iconst_3
istore_1

iconst_-99
iload_0
iload_1
invokestatic aval3/f(II)I
istore_0

iload_0
invokestatic io/println(I)V
bipush 6
istore_0

iconst_-99
iload_0
iload_1
invokestatic aval3/f(II)I
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
