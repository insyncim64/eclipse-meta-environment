#include <aterm2pbf.h>
#include <byteencoding.h>

#include <stdlib.h>
#include <string.h>

#define PDB_BOOL_HEADER 0x01
#define PDB_INTEGER_HEADER 0x02
#define PDB_BIG_INTEGER_HEADER 0x03
#define PDB_DOUBLE_HEADER 0x04
#define PDB_IEEE754_ENCODED_DOUBLE_HEADER 0x14
#define PDB_STRING_HEADER 0x05
#define PDB_SOURCE_LOCATION_HEADER 0x06
#define PDB_TUPLE_HEADER 0x07
#define PDB_NODE_HEADER 0x08
#define PDB_ANNOTATED_NODE_HEADER 0x09
#define PDB_CONSTRUCTOR_HEADER 0x0a
#define PDB_ANNOTATED_CONSTRUCTOR_HEADER 0x0b
#define PDB_LIST_HEADER 0x0c
#define PDB_SET_HEADER 0x0d
#define PDB_RELATION_HEADER 0x0e
#define PDB_MAP_HEADER 0x0f

#define PDB_SHARED_FLAG 0x80
#define PDB_TYPE_SHARED_FLAG 0x40
#define PDB_URL_SHARED_FLAG 0x20
#define PDB_NAME_SHARED_FLAG 0x20

#define PDB_HAS_FIELD_NAMES 0x20

static ByteBuffer createByteBuffer(unsigned int capacity){
        char *buffer;

        ByteBuffer byteBuffer = (ByteBuffer) malloc(sizeof(struct _ByteBuffer));
        if(byteBuffer == NULL){ fprintf(stderr, "Unable to allocate byte buffer.\n"); exit(1); }

        buffer = (char*) malloc(capacity * sizeof(char));
        if(buffer == NULL){ fprintf(stderr, "Unable to allocate backing array for the byte buffer.\n"); exit(1);}
        byteBuffer->buffer = buffer;
        byteBuffer->currentPos = buffer;

        byteBuffer->capacity = capacity;

        return byteBuffer;
}

static unsigned int getRemainingBufferSpace(ByteBuffer byteBuffer){
	return (unsigned int) (byteBuffer->capacity - (byteBuffer->currentPos - byteBuffer->buffer));
}

static unsigned int getCurrentByteBufferSize(ByteBuffer byteBuffer){
	return (unsigned int) (byteBuffer->currentPos - byteBuffer->buffer);
}

static void enlargeByteBuffer(ByteBuffer byteBuffer){
	char *buffer;
	int size = getCurrentByteBufferSize(byteBuffer);
	char *oldBuffer = byteBuffer->buffer;
	
	int newCapacity = byteBuffer->capacity << 1;
	
	buffer = (char*) malloc(newCapacity * sizeof(char));
	if(buffer == NULL){ fprintf(stderr, "Unable to allocate backing array for the byte buffer.\n"); exit(1);}
	memcpy(oldBuffer, buffer, size);
	byteBuffer->buffer = buffer;
	byteBuffer->currentPos = buffer + size;
	
	byteBuffer->capacity = newCapacity;
	
	free(oldBuffer);
}

static void destroyByteBuffer(ByteBuffer byteBuffer){
        free(byteBuffer->buffer);

        free(byteBuffer);
}

/* Under construction. */

static char *doSerialize(A2PWriter writer, A2PType expected, ATerm value){
	
	return NULL; // Temp.
}

static void doWriteType(A2PWriter writer, A2PType type){

}

static void writeType(A2PWriter writer, A2PType type){

}

static void writeBool(A2PWriter writer, ATermAppl boolean){

}

static void writeInteger(A2PWriter writer, ATermInt integer){

}

static void writeDouble(A2PWriter writer, ATermReal real){

}

static void writeString(A2PWriter writer, AFun string){

}

static void writeSourceLocation(A2PWriter writer, ATermAppl sourceLocation){

}

static void writeTuple(A2PWriter writer, A2PType expected, ATermAppl tuple){

}

static void writeNode(A2PWriter writer, A2PType expected, ATermAppl node){

}

static void writeAnnotatedNode(A2PWriter writer, A2PType expected, ATermAppl node){

}

static void writeConstructor(A2PWriter writer, A2PType expected, ATermAppl constructor){

}

static void writeAnnotatedConstructor(A2PWriter writer, A2PType expected, ATermAppl constructor){

}

static void writeList(A2PWriter writer, A2PType expected, ATermList list){

}

static void writeSet(A2PWriter writer, A2PType expected, ATermList set){

}

static void writeRelation(A2PWriter writer, A2PType expected, ATermList relation){

}

static void writeMap(A2PWriter writer, A2PType expected, ATermList map){

}

static void writeValueType(A2PWriter writer){

}

static void writeVoidType(A2PWriter writer){

}

static void writeBoolType(A2PWriter writer){

}

static void writeIntegerType(A2PWriter writer){

}

static void writeDoubleType(A2PWriter writer){

}

static void writeStringType(A2PWriter writer){

}

static void writeSourceLocationType(A2PWriter writer){

}

static void writeNodeType(A2PWriter writer, A2PType nodeType){

}

static void writeTupleType(A2PWriter writer, A2PType tupleType){

}

static void writeListType(A2PWriter writer, A2PType listType){

}

static void writeSetType(A2PWriter writer, A2PType setType){

}

static void writeRelationType(A2PWriter writer, A2PType relationType){

}

static void writeMapType(A2PWriter writer, A2PType mapType){

}

static void writeParameterType(A2PWriter writer, A2PType parameterType){

}

static void writeADTType(A2PWriter writer, A2PType adtType){

}

static void writeConstructorType(A2PWriter writer, A2PType constructorType){

}

static void writeAliasType(A2PWriter writer, A2PType aliasType){

}

/* End under construction. */

A2PWriter A2PcreateWriter(){
	A2PWriter writer = (A2PWriter) malloc(sizeof(struct A2PWriter));
	writer->valueSharingMap = IMcreateIDMappings(2.0f);
	writer->typeSharingMap = IMcreateIDMappings(2.0f);
	writer->pathSharingMap = IMcreateIDMappings(2.0f);
	writer->nameSharingMap = IMcreateIDMappings(2.0f);
	
	return writer;
}

void A2PdestroyWriter(A2PWriter writer){
	IMdestroyIDMappings(writer->valueSharingMap);
	IMdestroyIDMappings(writer->typeSharingMap);
	IMdestroyIDMappings(writer->pathSharingMap);
	IMdestroyIDMappings(writer->nameSharingMap);
	
	free(writer);
}

char *A2Pserialize(ATerm term, A2PType topType){
	A2PWriter writer = A2PcreateWriter();
	
	char *result = doSerialize(writer, topType, term);
	
	A2PdestroyWriter(writer);
	
	return result;
}

/* TODO The code that does stuff. */
