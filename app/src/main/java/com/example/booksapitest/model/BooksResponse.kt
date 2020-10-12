package com.example.booksapitest.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BooksResponse(
    val items: List<BookItem>
): Parcelable

@Parcelize
data class BookItem(
    val volumeInfo: VolumeInfo
):Parcelable

@Parcelize
data class VolumeInfo(
    val title: String,
    val imageLinks: ImageLinks
): Parcelable

@Parcelize
data class ImageLinks(
    val thumbnail: String
): Parcelable

