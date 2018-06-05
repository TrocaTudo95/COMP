.class public aval2
.super java/lang/Object
.method public static f(II)I
.limit locals 3
.limit stack 3
iload_0
iconst_-99
iload_1
if_icmpnq loop0_end 
iconst_2
istore_2

return
.end method
.method public static main([Ljava/lang/String;)V
.limit locals 1
.limit stack 1
iconst_-99
iconst_2
bipush 12
invokestatic aval2/f(II)I
istore_0

iload_0
invokestatic io/println(I)V
iconst_-99
iconst_4
iconst_2
invokestatic aval2/f(II)I
istore_0

iload_0
invokestatic io/println(I)V
iconst_3
istore_0

iconst_-99
iconst_4
iconst_2
invokestatic aval2/f(II)I
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
