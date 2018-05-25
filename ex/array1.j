.class public array1
.super java/lang/Object
.method public static print_array(I)V
.limit locals 5
.limit stack 5
iload_1
aload_1

iconst_0
istore_2

loop0:
iload_2
iload_0
if_icmpge loop0_end 
aload_1
iload_2
iload_2
iastore

iinc 2 1

goto loop0
loop0_end:
iconst_0
istore_2

loop1:
iload_2
iload_0
if_icmpge loop1_end 
aload_1
iload_2
iaload

ldc "a: "
invokestatic io/print(Ljava/lang/String;)V
iinc 2 1

goto loop1
loop1_end:
return
.end method
.method public static main([Ljava/lang/String;)V
.limit locals 5
.limit stack 5
bipush 10
invokestatic array1/print_array(I)V
return
.end method
.method static public <clinit>()V
.limit stack 0
.limit locals 0
return
.end method
