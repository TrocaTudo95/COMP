.class public array1
.super java/lang/Object
.method public static print_array(I)V
.limit locals 5
.limit stack 5
iload_1
arraylength
astore_1
iconst_0
istore_1
istore_1
astore_1
iconst_1
iadd
istore_1
iconst_0
istore_1
istore_1
invokestatic io/print([Ljava/lang/String;)V
iconst_1
iadd
istore_1
return
.end method
.method public static main([Ljava/lang/String;)V
.limit locals 5
.limit stack 5
arraylength
astore_1
invokestatic array1/print_array([I)V
return
.end method
.method static public <clinit>()V
.limit stack 0
.limit locals 0
return
.end method
