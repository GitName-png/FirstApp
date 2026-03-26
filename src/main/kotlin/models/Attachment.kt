package models

import com.eltex.models.AttachmentType

@JvmRecord
data class Attachment(val url: String?, val type: AttachmentType?) 