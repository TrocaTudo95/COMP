.class public aval7
.super java/lang/Object
.method public static Count(I)I
.limit locals 4
.limit stack 4
iconst_0
istore_1

istore_2

loop0:
iload_2
bipush 32
if_icmpge loop0_end 
iconst_-99
iload_0
iconst_1
istore_3

iload_3
iconst_1
if_icmpnq loop0_end 
iinc 1 1

iinc 0 1

iinc 2 1

goto loop0
loop0_end:
return
.end method
.method public static main([Ljava/lang/String;)V
.limit locals 1
.limit stack 1
iconst_-99
iconst_3
invokestatic aval7/Count(I)I
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
