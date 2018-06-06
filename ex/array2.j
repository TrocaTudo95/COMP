.class public array2
.super java/lang/Object
.method public static sum_array([I)I
.limit locals 3
.limit stack 3
iconst_0
istore_2

iconst_0
istore 4

loop0:
iload_2
aload_0
arraylength
if_icmpge loop0_end 
iload 4
aload_0
iload_2
iaload
iadd
istore 4

iinc 2 1

goto loop0
loop0_end:
return
.end method
.method public static main([Ljava/lang/String;)V
.limit locals 4
.limit stack 4
bipush 16
istore_1

iload_2
aload_2

iconst_0
istore 4

loop1:
iload 4
iload_1
if_icmpge loop1_end 
aload_2
iload 4
iconst_1
iastore

iinc 4 1

goto loop1
loop1_end:
invokestatic array2/sum_array([I)I
istore 6

ldc "sum of array elements = "
iload 6
invokestatic io/println(Ljava/lang/String;I)V
return
.end method
.method static public <clinit>()V
.limit stack 0
.limit locals 0
return
.end method
