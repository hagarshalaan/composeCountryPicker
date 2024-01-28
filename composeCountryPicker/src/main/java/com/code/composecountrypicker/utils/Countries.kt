package com.code.composecountrypicker.utils

import android.content.Context
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.code.composecountrypicker.ui.componants.paddingHigher
import com.code.composecountrypicker.ui.componants.paddingNormal
import com.code.composecountrypicker.ui.componants.paddingSmall
import java.util.Locale
import com.code.compose_picker.R
import com.code.composecountrypicker.ui.componants.searchBar

data class Country(
    val nameID: Int,
    val code: String,
    val codeText: String,
    val flag: Int,
    var selected: Boolean = false
)

fun countries() = listOf(
    Country(R.string.afghanistan, "+93", "AF", R.drawable.af),
    Country(R.string.albania, "+355", "AL", R.drawable.al),
    Country(R.string.algeria, "+213", "DZ", R.drawable.dz),
    Country(R.string.andorra, "+376", "AD", R.drawable.ad),
    Country(R.string.antarctica, "+672", "AQ", R.drawable.aq),
    Country(R.string.antigua_and_barbuda, "+672", "AG", R.drawable.ag),
    Country(R.string.armenia, "+374", "AM", R.drawable.am),
    Country(R.string.american_samoa, "+1684", "AS", R.drawable.`as`),
    Country(R.string.aland_islands, "+358", "AX", R.drawable.ax),
    Country(R.string.angola, "+244", "AO", R.drawable.ao),
    Country(R.string.anguilla, "+1264", "AI", R.drawable.ai),
    Country(R.string.argentina, "+54", "AR", R.drawable.aq),
    Country(R.string.aruba, "+297", "AW", R.drawable.aw),
    Country(R.string.australia, "+61", "AU", R.drawable.au),
    Country(R.string.austria, "+43", "AT", R.drawable.at),
    Country(R.string.azerbaijan, "+994", "AZ", R.drawable.az),
    Country(R.string.bahamas, "+1242", "BS", R.drawable.bs),
    Country(R.string.bahrain, "+973", "BH", R.drawable.bh),
    Country(R.string.bangladesh, "+880", "BD", R.drawable.bd),
    Country(R.string.belarus, "+375", "BY", R.drawable.by),
    Country(R.string.belgium, "+32", "BE", R.drawable.be),
    Country(R.string.belize, "+501", "BZ", R.drawable.bz),
    Country(R.string.benin, "+229", "BJ", R.drawable.bj),
    Country(R.string.bermuda, "+1441", "BM", R.drawable.bm),
    Country(R.string.bhutan, "+975", "BT", R.drawable.bt),
    Country(R.string.bolivia, "+591", "BT", R.drawable.bo),
    Country(R.string.bosnia, "+387", "BA", R.drawable.ba),
    Country(R.string.botswana, "+267", "BW", R.drawable.bw),
    Country(R.string.brazil, "+55", "BR", R.drawable.br),
    Country(R.string.british_indian_ocean, "+246", "IO", R.drawable.io),
    Country(R.string.brunei_darussalam, "+673", "BN", R.drawable.bn),
    Country(R.string.bulgaria, "+359", "BG", R.drawable.bg),
    Country(R.string.burkina_faso, "+226", "BF", R.drawable.bf),
    Country(R.string.burundi, "+257", "BI", R.drawable.bi),
    Country(R.string.cambodia, "+855", "KH", R.drawable.kh),
    Country(R.string.canada, "+1", "CA", R.drawable.ca),
    Country(R.string.cape_verde, "+238", "CV", R.drawable.cv),
    Country(R.string.cayman_islands, "+1345", "KY", R.drawable.ky),
    Country(R.string.central_african, "+236", "CF", R.drawable.cf),
    Country(R.string.chad, "+235", "TD", R.drawable.td),
    Country(R.string.chile, "+56", "CL", R.drawable.cl),
    Country(R.string.china, "+86", "CN", R.drawable.cn),
    Country(R.string.christmas_island, "+61", "CX", R.drawable.cx),
    Country(R.string.cocos, "+61", "CC", R.drawable.cc),
    Country(R.string.colombia, "+57", "CO", R.drawable.co),
    Country(R.string.comoros, "+269", "KM", R.drawable.km),
    Country(R.string.congo, "+242", "CG", R.drawable.cg),
    Country(R.string.congo_democratic, "+243", "CD", R.drawable.cd),
    Country(R.string.cook_islands, "+682", "CK", R.drawable.ck),
    Country(R.string.costa_rica, "+506", "CR", R.drawable.cr),
    Country(R.string.cote_dlvoire, "+225", "CI", R.drawable.ci),
    Country(R.string.croatia, "+385", "HR", R.drawable.hr),
    Country(R.string.cuba, "+53", "CU", R.drawable.cu),
    Country(R.string.cyprus, "+357", "CY", R.drawable.cy),
    Country(R.string.czech_republic, "+420", "CZ", R.drawable.cz),
    Country(R.string.denmark, "+45", "DK", R.drawable.dk),
    Country(R.string.djibouti, "+253", "DJ", R.drawable.dj),
    Country(R.string.dominica, "+1767", "DM", R.drawable.dm),
    Country(R.string.dominician_republic, "+1", "DO", R.drawable.ic_do),
    Country(R.string.ecuador, "+593", "EC", R.drawable.ec),
    Country(R.string.egypt, "+20", "EG", R.drawable.eg),
    Country(R.string.el_salvador, "+503", "SV", R.drawable.sv),
    Country(R.string.equatorial_guinea, "+240", "GQ", R.drawable.gq),
    Country(R.string.eritrea, "+291", "ER", R.drawable.er),
    Country(R.string.estonia, "+372", "EE", R.drawable.ee),
    Country(R.string.ethiopia, "+251", "ET", R.drawable.et),
    Country(R.string.falkland_islands, "+500", "FK", R.drawable.fk),
    Country(R.string.faroe_islands, "+298", "FO", R.drawable.fo),
    Country(R.string.fiji, "+679", "FJ", R.drawable.fj),
    Country(R.string.finland, "+358", "FI", R.drawable.fi),
    Country(R.string.france, "+33", "FR", R.drawable.fr),
    Country(R.string.french_guyana, "+594", "GF", R.drawable.gf),
    Country(R.string.french_polynesia, "+689", "PF", R.drawable.pf),
    Country(R.string.gabon, "+241", "GA", R.drawable.ga),
    Country(R.string.gambia, "+220", "GM", R.drawable.gm),
    Country(R.string.georgia, "+995", "GE", R.drawable.ge),
    Country(R.string.germany, "+49", "DE", R.drawable.de),
    Country(R.string.ghana, "+233", "GH", R.drawable.gh),
    Country(R.string.gibraltar, "+350", "GI", R.drawable.gi),
    Country(R.string.greece, "+30", "GR", R.drawable.gr),
    Country(R.string.greenland, "+299", "GL", R.drawable.gl),
    Country(R.string.grenada, "+1473", "GD", R.drawable.gd),
    Country(R.string.guadeloupe, "+590", "GP", R.drawable.gp),
    Country(R.string.guam, "+1671", "GU", R.drawable.gu),
    Country(R.string.guatemala, "+502", "GT", R.drawable.gt),
    Country(R.string.guernsey, "+44", "GG", R.drawable.gg),
    Country(R.string.guinea, "+224", "GN", R.drawable.gn),
    Country(R.string.guinea_bissau, "+245", "GW", R.drawable.gw),
    Country(R.string.guyana, "+592", "GY", R.drawable.gy),
    Country(R.string.haiti, "+509", "HT", R.drawable.ht),
    Country(R.string.holy_see, "+379", "VA", R.drawable.va),
    Country(R.string.honduras, "+504", "HN", R.drawable.hn),
    Country(R.string.hong_kong, "+852", "HK", R.drawable.hk),
    Country(R.string.hungary, "+36", "HU", R.drawable.hu),
    Country(R.string.iceland, "+354", "IS", R.drawable.`is`),
    Country(R.string.india, "+91", "IN", R.drawable.`in`),
    Country(R.string.indonesia, "+62", "ID", R.drawable.id),
    Country(R.string.iran, "+98", "IR", R.drawable.ir),
    Country(R.string.iraq, "+964", "IQ", R.drawable.iq),
    Country(R.string.ireland, "+353", "IE", R.drawable.ie),
    Country(R.string.isle_of_man, "+44", "IM", R.drawable.im),
    Country(R.string.israil, "+972", "IL", R.drawable.il),
    Country(R.string.italia, "+39", "IT", R.drawable.it),
    Country(R.string.jamaica, "+876", "JM", R.drawable.jm),
    Country(R.string.japan, "+81", "JP", R.drawable.jp),
    Country(R.string.jersey, "+44", "JE", R.drawable.je),
    Country(R.string.jordan, "+962", "JO", R.drawable.jo),
    Country(R.string.kazakhstan, "+7", "KZ", R.drawable.kz),
    Country(R.string.kenya, "+254", "KE", R.drawable.ke),
    Country(R.string.kiribati, "+686", "KI", R.drawable.ki),
    Country(R.string.kosovo, "+383", "XK", R.drawable.xk),
    Country(R.string.kuwait, "+965", "KW", R.drawable.kw),
    Country(R.string.kyrgyzstan, "+996", "KG", R.drawable.kg),
    Country(R.string.laos, "+856", "LA", R.drawable.la),
    Country(R.string.latvia, "+371", "LV", R.drawable.lv),
    Country(R.string.lebanon, "+961", "LB", R.drawable.lb),
    Country(R.string.lesotho, "+266", "LS", R.drawable.ls),
    Country(R.string.liberia, "+231", "LR", R.drawable.lr),
    Country(R.string.libya, "+218", "LY", R.drawable.ly),
    Country(R.string.liechtenstein, "+423", "LI", R.drawable.li),
    Country(R.string.lithuania, "+370", "LT", R.drawable.lt),
    Country(R.string.luxembourg, "+352", "LU", R.drawable.lu),
    Country(R.string.macau, "+853", "MO", R.drawable.mo),
    Country(R.string.north_macedonia, "+389", "MK", R.drawable.mk),
    Country(R.string.madagascar, "+261", "MG", R.drawable.mg),
    Country(R.string.malawi, "+265", "MW", R.drawable.mw),
    Country(R.string.malaysia, "+60", "MY", R.drawable.my),
    Country(R.string.maldives, "+960", "MV", R.drawable.mv),
    Country(R.string.mali, "+223", "ML", R.drawable.ml),
    Country(R.string.malta, "+356", "MT", R.drawable.mt),
    Country(R.string.marshall_islands, "+692", "MH", R.drawable.mh),
    Country(R.string.martinique, "+596", "MQ", R.drawable.mq),
    Country(R.string.mauriatana, "+222", "MR", R.drawable.mr),
    Country(R.string.mauritius, "+230", "MU", R.drawable.mu),
    Country(R.string.mayotte, "+262", "YT", R.drawable.yt),
    Country(R.string.mexico, "+52", "MX", R.drawable.mx),
    Country(R.string.micro, "+691", "FM", R.drawable.fm),
    Country(R.string.moldova, "+373", "MD", R.drawable.md),
    Country(R.string.monaco, "+377", "MC", R.drawable.mc),
    Country(R.string.mongolia, "+976", "MN", R.drawable.mn),
    Country(R.string.montenegro, "+382", "ME", R.drawable.me),
    Country(R.string.montserrat, "+1664", "MS", R.drawable.ms),
    Country(R.string.morocco, "+212", "MA", R.drawable.ma),
    Country(R.string.mozambique, "+258", "MZ", R.drawable.mz),
    Country(R.string.myanmar, "+95", "MM", R.drawable.mm),
    Country(R.string.namibia, "+264", "NA", R.drawable.na),
    Country(R.string.nauru, "+674", "NR", R.drawable.nr),
    Country(R.string.nepal, "+977", "NP", R.drawable.np),
    Country(R.string.netherlands, "+31", "NL", R.drawable.nl),
    Country(R.string.new_caledonia, "+687", "NC", R.drawable.nc),
    Country(R.string.new_zealand, "+64", "NZ", R.drawable.nz),
    Country(R.string.nicaragua, "+505", "NI", R.drawable.ni),
    Country(R.string.niger, "+227", "NE", R.drawable.ne),
    Country(R.string.nigeria, "+234", "NG", R.drawable.ng),
    Country(R.string.niue, "+683", "NU", R.drawable.nu),
    Country(R.string.norfolk, "+672", "NF", R.drawable.nf),
    Country(R.string.north_korea, "+850", "KP", R.drawable.kp),
    Country(R.string.northern_mariana, "+1670", "MP", R.drawable.mp),
    Country(R.string.norway, "+47", "NO", R.drawable.no),
    Country(R.string.oman, "+968", "OM", R.drawable.om),
    Country(R.string.pakistan, "+92", "PK", R.drawable.pk),
    Country(R.string.paula, "+680", "PW", R.drawable.pw),
    Country(R.string.state_of_palestine, "+970", "PS", R.drawable.ps),
    Country(R.string.panama, "+507", "PA", R.drawable.pa),
    Country(R.string.papua_new_guinea, "+675", "PG", R.drawable.pg),
    Country(R.string.paraguay, "+595", "PY", R.drawable.py),
    Country(R.string.peru, "+51", "PE", R.drawable.pe),
    Country(R.string.philippinies, "+63", "PH", R.drawable.ph),
    Country(R.string.pitcairn, "+64", "PN", R.drawable.pn),
    Country(R.string.poland, "+48", "PL", R.drawable.pl),
    Country(R.string.portugal, "+351", "PT", R.drawable.pt),
    Country(R.string.puerto_rico, "+1", "PR", R.drawable.pr),
    Country(R.string.qatar, "+974", "QA", R.drawable.qa),
    Country(R.string.romania, "+40", "RO", R.drawable.ro),
    Country(R.string.russia, "+7", "RU", R.drawable.ru),
    Country(R.string.rwanda, "+250", "RW", R.drawable.rw),
    Country(R.string.reunion, "+262", "RE", R.drawable.re),
    Country(R.string.saint_barhelemy, "+590", "BL", R.drawable.bl),
    Country(R.string.saint_helena, "+290", "SH", R.drawable.sh),
    Country(R.string.saint_kitts, "+1869", "KN", R.drawable.kn),
    Country(R.string.saint_lucia, "+1758", "LC", R.drawable.lc),
    Country(R.string.saint_martin, "+590", "MF", R.drawable.mf),
    Country(R.string.saint_pierre, "+508", "PM", R.drawable.pm),
    Country(R.string.saint_vincent, "+1784", "VC", R.drawable.vc),
    Country(R.string.samoa, "+685", "WS", R.drawable.ws),
    Country(R.string.san_marino, "+378", "SM", R.drawable.sm),
    Country(R.string.sao_tome, "+239", "ST", R.drawable.st),
    Country(R.string.saudi_arabia, "+966", "SA", R.drawable.sa),
    Country(R.string.senegal, "+221", "SN", R.drawable.sa),
    Country(R.string.serbia, "+381", "RS", R.drawable.rs),
    Country(R.string.seychelles, "+248", "SC", R.drawable.sc),
    Country(R.string.sierra_leone, "+232", "SL", R.drawable.sl),
    Country(R.string.singapore, "+65", "SG", R.drawable.sg),
    Country(R.string.sint_maarten, "+1721", "SX", R.drawable.sx),
    Country(R.string.slovakia, "+421", "SK", R.drawable.sk),
    Country(R.string.solomon_islands, "+677", "SB", R.drawable.sb),
    Country(R.string.somali, "+52", "SO", R.drawable.so),
    Country(R.string.south_africa, "+27", "ZA", R.drawable.za),
    Country(R.string.south_georia_and_south_sandwich, "+500", "GS", R.drawable.gs),
    Country(R.string.south_korea, "+82", "KR", R.drawable.kr),
    Country(R.string.south_sudan, "+211", "SS", R.drawable.ss),
    Country(R.string.spain, "+34", "ES", R.drawable.es),
    Country(R.string.sri_lanka, "+94", "LK", R.drawable.lk),
    Country(R.string.sudan, "+249", "SD", R.drawable.sd),
    Country(R.string.suriname, "+597", "SR", R.drawable.sr),
    Country(R.string.svalbard_and_jan_mayen, "+47", "SJ", R.drawable.sj),
    Country(R.string.swaziland, "+268", "SZ", R.drawable.sz),
    Country(R.string.sweden, "+46", "SE", R.drawable.se),
    Country(R.string.switzerland, "+41", "CH", R.drawable.ch),
    Country(R.string.syrian, "+963", "SY", R.drawable.sy),
    Country(R.string.taiwan, "+886", "TW", R.drawable.tw),
    Country(R.string.taijikistan, "+992", "TJ", R.drawable.tj),
    Country(R.string.tanzania, "+255", "TZ", R.drawable.tz),
    Country(R.string.thailand, "+66", "TH", R.drawable.th),
    Country(R.string.timor_leste, "+670", "TL", R.drawable.tl),
    Country(R.string.togo, "+228", "TG", R.drawable.tg),
    Country(R.string.tokelau, "+690", "TK", R.drawable.tk),
    Country(R.string.tonga, "+676", "TO", R.drawable.to),
    Country(R.string.trinidad_and_tobago, "+1868", "TT", R.drawable.tt),
    Country(R.string.tunisia, "+216", "TN", R.drawable.tn),
    Country(R.string.turkey, "+90", "TR", R.drawable.tr),
    Country(R.string.turkmenistan, "+993", "TM", R.drawable.tm),
    Country(R.string.turks_and_caicos, "+1649", "TC", R.drawable.tc),
    Country(R.string.tuvalu, "+688", "TV", R.drawable.tv),
    Country(R.string.uganda, "+256", "UG", R.drawable.ug),
    Country(R.string.ukraina, "+380", "UA", R.drawable.ua),
    Country(R.string.united_arab_emirates, "+971", "AE", R.drawable.ae),
    Country(R.string.united_kingdom, "+44", "GB", R.drawable.gb),
    Country(R.string.united_states_america, "+1", "US", R.drawable.us),
    Country(R.string.uruguay, "+598", "UY", R.drawable.uy),
    Country(R.string.uzbekistan, "+998", "UZ", R.drawable.uz),
    Country(R.string.vanuatu, "+678", "VU", R.drawable.vu),
    Country(R.string.venezuela, "+58", "VE", R.drawable.ve),
    Country(R.string.vietnam, "+84", "VN", R.drawable.vn),
    Country(R.string.virgin_island_us, "+1340", "VI", R.drawable.vi),
    Country(R.string.virgin_islands, "+1284", "VG", R.drawable.vg),
    Country(R.string.walli_and_fatuna, "+681", "WF", R.drawable.wf),
    Country(R.string.yemen, "+967", "YE", R.drawable.ye),
    Country(R.string.zambia, "+260", "ZM", R.drawable.zm),
    Country(R.string.zimbabwe, "+263", "ZW", R.drawable.zw),

    )

@Composable
private fun CountryItem(
    country: Country,
    onItemClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .padding(paddingNormal())
            .clickable(onClick = onItemClick)
    )
    {
        Image(
            painter = painterResource(id = country.flag),
            contentDescription = stringResource(id = country.nameID),
            modifier = Modifier
                .size(30.dp)
                .padding(end = paddingNormal()),
            alignment = Alignment.Center
        )
        Text(
            text = stringResource(id = country.nameID),
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.padding(paddingSmall()))
        Text(
            text = country.code,
            textAlign = TextAlign.Start
        )
    }
    Divider()


}

@Composable
fun CountryCodePicker(
    modifier: Modifier = Modifier,
    countries: List<Country> = countries(),
    onCountrySelected: (Country) -> Unit,
    displaySearch: Boolean = true,
    searchModifier: Modifier = Modifier,
    context: Context
) {
    val filteredCountries = remember { mutableStateListOf<Country>() }

    Column(
        modifier
            .padding(paddingHigher())
            .fillMaxWidth()
    ) {
        if (displaySearch) {
            searchBar(onValueChange = { query ->
                filterCountries(countries, query, context) { filteredList ->
                    filteredCountries.clear()
                    filteredCountries.addAll(filteredList)
                }
            }, modifier = searchModifier.fillMaxWidth())
        }
        LazyColumn(content = {
            items(filteredCountries.size) { index ->
                val countryItem = filteredCountries[index]
                CountryItem(country = countryItem) {
                    onCountrySelected(countryItem)
                }
            }
        })
    }
    // Initialize the filteredCountries list with the full list of countries
    LaunchedEffect(countries) {
        filteredCountries.addAll(countries)
    }
}


fun filterCountries(
    countries: List<Country>,
    query: String,
    context: Context,
    onFiltered: (List<Country>) -> Unit
) {
    if (query.isEmpty()) {
        // If the query is empty, return the full list of countries
        onFiltered(countries)
    } else {
        val filteredList = countries.filter { country ->
            val countryName = context.getString(country.nameID)
            country.code.contains(query, ignoreCase = true) ||
                    countryName.contains(query, ignoreCase = true) ||
                    country.code == query
        }
        onFiltered(filteredList)
    }
}

@Composable
fun codeCountryView(
    modifier: Modifier = Modifier,
    visibleFullCountry: Boolean = false
) {
    val context = LocalContext.current
    val isCountryCodePickerVisible = remember {
        mutableStateOf(false)
    }
    val selectedCountry= remember {
        mutableStateOf<Country?>(null)
    }
    if (isCountryCodePickerVisible.value) {
        CountryCodePicker(
            onCountrySelected = {
                Log.d("CountryCodePicker:", "country:${it.nameID}")
                isCountryCodePickerVisible.value = false
                selectedCountry.value = it
            },
            context = context
        )
    } else {
        Row(modifier = modifier
            .padding(paddingNormal())
            .clickable {
                isCountryCodePickerVisible.value = true
            }) {
            SelectedLocaleCountryInfo(selectedCountry=selectedCountry.value, visibleFullCountry = visibleFullCountry)
        }
    }
}

@Composable
fun SelectedLocaleCountryInfo(countries: List<Country> = countries(), selectedCountry: Country?=null, visibleFullCountry:Boolean=true
) {
    val locale =Locale.getDefault()
    val localeCountryCode = locale.country
    Log.d("main_locale_",localeCountryCode+":iso,"+locale.isO3Country)

    val country = selectedCountry ?: countries.find { it.codeText == localeCountryCode }
    val countryName = if (country != null) stringResource(country.nameID) else ""
    val codeText = country?.codeText ?: ""
    val code = country?.code ?: ""
    val flagResourceId = country?.flag ?: R.drawable.af


    Row(modifier = Modifier.padding(8.dp)) {
        Image(
            painter = painterResource(flagResourceId),
            contentDescription = "Flag",
            modifier = Modifier.padding(end = paddingNormal()).size(24.dp)
        )
        val countryText= if(visibleFullCountry) "$countryName ($code) " else "$codeText ($code) "
        Text(text =  countryText)
    }
}