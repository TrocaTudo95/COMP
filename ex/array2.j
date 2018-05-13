.class public array2
.super java/lang/Object
.method public static sum_array([I)I
.limit locals 5
.limit stack 5
iconst_0
istore_1

iconst_0
istore_2


aload_iadd
istore_2

iconst_1
iadd
istore_1

return
.end method
.method public static main([Ljava/lang/String;)V
.limit locals 5
.limit stack 5
bitpush 16
istore_3

iload_3
astore_1

iconst_0
istore_1


iconst_1
astore_1

iconst_1
iadd
istore_1

invokestatic array2/sum_array([I)I
istore_2

ldc "sum of array elements = "
iload_1
invokestatic io/println([Ljava/lang/String;I)V
return
.end method
.method static public <clinit>()V
.limit stack 0
.limit locals 0
return
.end method
