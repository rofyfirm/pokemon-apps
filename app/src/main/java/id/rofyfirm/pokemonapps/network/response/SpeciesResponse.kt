package id.rofyfirm.pokemonapps.network.response

import com.google.gson.annotations.SerializedName

class SpeciesResponse {
    @SerializedName("id"                     ) var id                   : Int?                         = null
    @SerializedName("name"                   ) var name                 : String?                      = null
    @SerializedName("order"                  ) var order                : Int?                         = null
    @SerializedName("gender_rate"            ) var genderRate           : Int?                         = null
    @SerializedName("capture_rate"           ) var captureRate          : Int?                         = null
    @SerializedName("base_happiness"         ) var baseHappiness        : Int?                         = null
    @SerializedName("is_baby"                ) var isBaby               : Boolean?                     = null
    @SerializedName("is_legendary"           ) var isLegendary          : Boolean?                     = null
    @SerializedName("is_mythical"            ) var isMythical           : Boolean?                     = null
    @SerializedName("hatch_counter"          ) var hatchCounter         : Int?                         = null
    @SerializedName("has_gender_differences" ) var hasGenderDifferences : Boolean?                     = null
    @SerializedName("forms_switchable"       ) var formsSwitchable      : Boolean?                     = null
    @SerializedName("pokedex_numbers"        ) var pokedexNumbers       : ArrayList<PokedexNumbers>    = arrayListOf()
    @SerializedName("evolves_from_species"   ) var evolvesFromSpecies   : EvolvesFromSpecies?          = EvolvesFromSpecies()
    @SerializedName("evolution_chain"        ) var evolutionChain       : EvolutionChain?              = EvolutionChain()
    @SerializedName("names"                  ) var names                : ArrayList<Names>             = arrayListOf()
    @SerializedName("flavor_text_entries"    ) var flavorTextEntries    : ArrayList<FlavorTextEntries> = arrayListOf()
    @SerializedName("form_descriptions"      ) var formDescriptions     : ArrayList<FormDescriptions>  = arrayListOf()


    data class Pokedex (
        @SerializedName("name" ) var name : String? = null,
        @SerializedName("url"  ) var url  : String? = null

    )

    data class PokedexNumbers (
        @SerializedName("entry_number" ) var entryNumber : Int?     = null,
        @SerializedName("pokedex"      ) var pokedex     : Pokedex? = Pokedex()
    )

    data class EvolvesFromSpecies (
        @SerializedName("name" ) var name : String? = null,
        @SerializedName("url"  ) var url  : String? = null
    )

    data class EvolutionChain (
        @SerializedName("url" ) var url : String? = null
    )

    data class Names (
        @SerializedName("name"     ) var name     : String?   = null,
        @SerializedName("language" ) var language : Language? = Language()
    )

    data class Language (
        @SerializedName("name" ) var name : String? = null,
        @SerializedName("url"  ) var url  : String? = null
    )

    data class FlavorTextEntries (
        @SerializedName("flavor_text" ) var flavorText : String?   = null,
        @SerializedName("language"    ) var language   : Language? = Language(),
        @SerializedName("version"     ) var version    : Version?  = Version()
    )

    data class Version (
        @SerializedName("name" ) var name : String? = null,
        @SerializedName("url"  ) var url  : String? = null
    )

    data class FormDescriptions (
        @SerializedName("description" ) var description : String?   = null,
        @SerializedName("language"    ) var language    : Language? = Language()

    )
}