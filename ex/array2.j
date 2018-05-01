.class public array2
.super java/lang/Object
.method public static sum_array([I)I
.limit locals 5
.limit stack 5
iconst_0istore_1
iconst_0istore_2
istore_3
iadd
istore 4
iconst_1iadd
istore 5
return
.end method
.method public static main([Ljava/lang/String;)V
.limit locals 5
.limit stack 5
iconst_16istore 6
iload_0
arraylength
istore 7
iconst_0istore 8
istore 9
iconst_1istore 10
iconst_1iadd
istore 11
invokestatic array2/sum_array(I)INT
istore 12
return
.end method
.method static public <clinit>()V
.limit stack 0
.limit locals 0
return
.end method
