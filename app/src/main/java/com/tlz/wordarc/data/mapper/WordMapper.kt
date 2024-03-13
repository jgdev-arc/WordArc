package com.tlz.wordarc.data.mapper

import com.tlz.wordarc.data.dto.DefinitionDto
import com.tlz.wordarc.data.dto.MeaningDto
import com.tlz.wordarc.data.dto.WordItemDto
import com.tlz.wordarc.domain.model.Definition
import com.tlz.wordarc.domain.model.Meaning
import com.tlz.wordarc.domain.model.WordItem

fun WordItemDto.toWordItem() = WordItem(
    word = word ?: "",
    meanings = meanings?.map {
    it.toMeaning()
    } ?: emptyList(),
    phonetic = phonetic ?: ""
)

fun MeaningDto.toMeaning() = Meaning(
    definition = definitionDtoToDefinition(definitions?.get(0)),
    partOfSpeech = partOfSpeech ?: ""
)

fun definitionDtoToDefinition(definitionDto: DefinitionDto?) = Definition(
    definition = definitionDto?.definition ?: "",
    example = definitionDto?.example ?: ""
)