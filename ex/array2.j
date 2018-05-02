.class public array2
.super java/lang/Object
.method public static sum_array([I)I
.limit locals 5
.limit stack 5
iconst_0
istore_1
iconst_0
istore_2
istore_1
iadd
istore_2
iconst_1
iadd
istore_1
return
.end method
.method public static main([Ljava/lang/String;)V
.limit locals 5
.limit stack 5
iconst_16
istore_3
iload_1
arraylength
istore_4
iconst_0
istore 1
istore 1
iconst_1
istore 4
iconst_1
iadd
istore 1
invokestatic array2/sum_array(I)I
istore 2
invokestatic io/println([Ljava/lang/String;I)V
return
.end method
.method static public <clinit>()V
.limit stack 0
.limit locals 0
return
.end method
