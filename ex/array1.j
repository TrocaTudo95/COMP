.class public array1
.super java/lang/Object
.method public static print_array(I)V
.limit locals 4
.limit stack 4
iload_1
aload_1

iconst_-99
aload_1
iconst_2
iadd
istore_2

loop0:
iload_2
iconst_-99
aload_1
if_icmpge loop0_end 
aload_1
iload_2
iconst_-99
iload_2
iastore

iinc 2 1

goto loop0
loop0_end:
iconst_0
istore_2

loop1:
iload_2
iconst_-99
aload_1
arraylength
if_icmpge loop1_end 
iconst_-99
aload_1
iload_2
iaload
istore_3

ldc "a: "
iload_3
invokestatic io/print(Ljava/lang/String;I)V
iinc 2 1

goto loop1
loop1_end:
return
.end method
.method public static main([Ljava/lang/String;)V
.limit locals 1
.limit stack 1
bipush 10
invokestatic array1/print_array(I)V
bipush 10
istore_0

return
.end method
.method static public <clinit>()V
.limit stack 0
.limit locals 0
return
.end method
