package id.rofyfirm.pokemonapps.network.response

import com.google.gson.annotations.SerializedName

class StatResponse {
    @SerializedName("abilities") var abilities: ArrayList<Abilities>? = null
    @SerializedName("base_experience") var baseExperience: Int? = null
    @SerializedName("forms") var forms: ArrayList<Forms>? = null
    @SerializedName("game_indices") var gameIndices: ArrayList<GameIndices>? = null
    @SerializedName("height") var height: Int? = null
    @SerializedName("id") var id: Int? = null
    @SerializedName("is_default") var isDefault: Boolean? = null
    @SerializedName("location_area_encounters") var locationAreaEncounters : String? = null
    @SerializedName("moves") var moves: ArrayList<Moves>? = null
    @SerializedName("name") var name: String? = null
    @SerializedName("order") var order: Int? = null
    @SerializedName("past_types") var pastTypes: ArrayList<String>?= null
    @SerializedName("species") var species: Species? = null
    @SerializedName("sprites") var sprites: Sprites? = null
    @SerializedName("stats") var stats: ArrayList<Stats>? = null
    @SerializedName("types") var types: ArrayList<Types>? = null
    @SerializedName("weight") var weight: Int? = null

    data class Abilities (
        @SerializedName("ability"   ) var ability  : Ability? = Ability(),
        @SerializedName("is_hidden" ) var isHidden : Boolean? = null,
        @SerializedName("slot"      ) var slot     : Int?     = null

    )

    data class Ability (
        @SerializedName("name" ) var name : String? = null,
        @SerializedName("url"  ) var url  : String? = null

    )

    data class Forms (
        @SerializedName("name" ) var name : String? = null,
        @SerializedName("url"  ) var url  : String? = null
    )

    data class Version (
        @SerializedName("name" ) var name : String? = null,
        @SerializedName("url"  ) var url  : String? = null
    )

    data class GameIndices (
        @SerializedName("game_index" ) var gameIndex : Int?     = null,
        @SerializedName("version"    ) var version   : Version? = Version()
    )

    data class Move (
        @SerializedName("name" ) var name : String? = null,
        @SerializedName("url"  ) var url  : String? = null
    )

    data class MoveLearnMethod (
        @SerializedName("name" ) var name : String? = null,
        @SerializedName("url"  ) var url  : String? = null
    )

    data class VersionGroup (
        @SerializedName("name" ) var name : String? = null,
        @SerializedName("url"  ) var url  : String? = null
    )

    data class VersionGroupDetails (
        @SerializedName("level_learned_at"  ) var levelLearnedAt  : Int?             = null,
        @SerializedName("move_learn_method" ) var moveLearnMethod : MoveLearnMethod? = MoveLearnMethod(),
        @SerializedName("version_group"     ) var versionGroup    : VersionGroup?    = VersionGroup()
    )

    data class Moves (
        @SerializedName("move"                  ) var move                : Move?                          = Move(),
        @SerializedName("version_group_details" ) var versionGroupDetails : ArrayList<VersionGroupDetails> = arrayListOf()
    )

    data class Species (
        @SerializedName("name" ) var name : String? = null,
        @SerializedName("url"  ) var url  : String? = null
    )

    data class DreamWorld (
        @SerializedName("front_default" ) var frontDefault : String? = null,
        @SerializedName("front_female"  ) var frontFemale  : String? = null
    )

    data class Home (
        @SerializedName("front_default"      ) var frontDefault     : String? = null,
        @SerializedName("front_female"       ) var frontFemale      : String? = null,
        @SerializedName("front_shiny"        ) var frontShiny       : String? = null,
        @SerializedName("front_shiny_female" ) var frontShinyFemale : String? = null
    )

    data class OfficialArtwork (
        @SerializedName("front_default" ) var frontDefault : String? = null
    )

    data class Other (
        @SerializedName("dream_world"      ) var dreamWorld       : DreamWorld?       = DreamWorld(),
        @SerializedName("home"             ) var home             : Home?             = Home(),
        @SerializedName("official-artwork" ) var officialArtwork : OfficialArtwork? = OfficialArtwork()
    )

    data class Sprites (
        @SerializedName("back_default"       ) var backDefault      : String?   = null,
        @SerializedName("back_female"        ) var backFemale       : String?   = null,
        @SerializedName("back_shiny"         ) var backShiny        : String?   = null,
        @SerializedName("back_shiny_female"  ) var backShinyFemale  : String?   = null,
        @SerializedName("front_default"      ) var frontDefault     : String?   = null,
        @SerializedName("front_female"       ) var frontFemale      : String?   = null,
        @SerializedName("front_shiny"        ) var frontShiny       : String?   = null,
        @SerializedName("front_shiny_female" ) var frontShinyFemale : String?   = null,
        @SerializedName("other"              ) var other            : Other?    = Other(),
//        @SerializedName("versions"           ) var versions         : Versions? = Versions()
    )

    data class Stat (
        @SerializedName("name" ) var name : String? = null,
        @SerializedName("url"  ) var url  : String? = null
    )

    data class Stats (
        @SerializedName("base_stat" ) var baseStat : Int?  = null,
        @SerializedName("effort"    ) var effort   : Int?  = null,
        @SerializedName("stat"      ) var stat     : Stat? = Stat()
    )

    data class Type (
        @SerializedName("name" ) var name : String? = null,
        @SerializedName("url"  ) var url  : String? = null
    )

    data class Types (
        @SerializedName("slot" ) var slot : Int?  = null,
        @SerializedName("type" ) var type : Type? = Type()

    )
}