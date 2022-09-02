package com.nftmarket.database

import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.nftmarket.model.ApplicationUser

fun getCollection(collectionName:String)
        : CollectionReference {
    val db = Firebase.firestore
    return db.collection(collectionName)
}
fun addUserToFireStore(
    user: ApplicationUser
    , onSuccessListener: OnSuccessListener<Void>
    , onFailureListener: OnFailureListener
){
    val userCollection = getCollection(ApplicationUser.COLLECTION_NAME)
    val userDoc =  userCollection.document(user.id!!)
    userDoc.set(user).
    addOnSuccessListener (onSuccessListener)
        .addOnFailureListener(onFailureListener)
}
fun getUser(
    uid: String,
    onSuccessListener: OnSuccessListener<DocumentSnapshot>,
    onFailureListener: OnFailureListener
) {
    val collectionRef = getCollection(ApplicationUser.COLLECTION_NAME)
    collectionRef.document(uid).get().addOnSuccessListener(onSuccessListener)
        .addOnFailureListener(onFailureListener)
}
