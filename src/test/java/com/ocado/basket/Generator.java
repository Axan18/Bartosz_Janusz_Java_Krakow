package com.ocado.basket;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.util.*;

public class Generator {
    public static void generator()
    {
        List<String> deliveryTypes = new ArrayList<>();
        deliveryTypes.add("Pick-up point");
        deliveryTypes.add("Parcel locker");
        deliveryTypes.add("Courier");
        deliveryTypes.add("Next day shipping");
        deliveryTypes.add("Mailbox delivery");
        deliveryTypes.add("Express Collection");
        deliveryTypes.add("InPost locker");
        deliveryTypes.add("Allegro Parcel Locker");
        deliveryTypes.add("DPD Pickup");
        deliveryTypes.add("Poczta Polska");
        List<String> items = List.of("a",
                "abandon",
                "ability",
                "able",
                "abortion",
                "about",
                "above",
                "abroad",
                "absence",
                "absolute",
                "absolutely",
                "absorb",
                "abuse",
                "academic",
                "accept",
                "access",
                "accident",
                "accompany",
                "accomplish",
                "according",
                "account",
                "accurate",
                "accuse",
                "achieve",
                "achievement",
                "acid",
                "acknowledge",
                "acquire",
                "across",
                "act",
                "action",
                "active",
                "activist",
                "activity",
                "actor",
                "actress",
                "actual",
                "actually",
                "ad",
                "adapt",
                "add",
                "addition",
                "additional",
                "address",
                "adequate",
                "adjust",
                "adjustment",
                "administration",
                "administrator",
                "admire",
                "admission",
                "admit",
                "adolescent",
                "adopt",
                "adult",
                "advance",
                "advanced",
                "advantage",
                "adventure",
                "advertising",
                "advice",
                "advise",
                "adviser",
                "advocate",
                "affair",
                "affect",
                "afford",
                "afraid",
                "African",
                "African-American",
                "after",
                "afternoon",
                "again",
                "against",
                "age",
                "agency",
                "agenda",
                "agent",
                "aggressive",
                "ago",
                "agree",
                "agreement",
                "agricultural",
                "ah",
                "ahead",
                "aid",
                "aide",
                "AIDS",
                "aim",
                "air",
                "aircraft",
                "airline",
                "airport",
                "album",
                "alcohol",
                "alive",
                "all",
                "alliance",
                "allow",
                "ally",
                "almost",
                "alone",
                "along",
                "already",
                "also",
                "alter",
                "alternative",
                "although",
                "always",
                "AM",
                "amazing",
                "American",
                "among",
                "amount",
                "analysis",
                "analyst",
                "analyze",
                "ancient",
                "and",
                "anger",
                "angle",
                "angry",
                "animal",
                "anniversary",
                "announce",
                "annual",
                "another",
                "answer",
                "anticipate",
                "anxiety",
                "any",
                "anybody",
                "anymore",
                "anyone",
                "anything",
                "anyway",
                "anywhere",
                "apart",
                "apartment",
                "apparent",
                "apparently",
                "appeal",
                "appear",
                "appearance",
                "apple",
                "application",
                "apply",
                "appoint",
                "appointment",
                "appreciate",
                "approach",
                "appropriate",
                "approval",
                "approve",
                "approximately",
                "Arab",
                "architect",
                "area",
                "argue",
                "argument",
                "arise",
                "arm",
                "armed",
                "army",
                "around",
                "arrange",
                "arrangement",
                "arrest",
                "arrival",
                "arrive",
                "art",
                "article",
                "artist",
                "artistic",
                "as",
                "Asian",
                "aside",
                "ask",
                "asleep",
                "aspect",
                "assault",
                "assert",
                "assess",
                "assessment",
                "asset",
                "assign",
                "assignment",
                "assist",
                "assistance",
                "assistant",
                "associate",
                "association",
                "cotton",
                "couch",
                "could",
                "council",
                "counselor",
                "count",
                "counter",
                "country",
                "county",
                "couple",
                "courage",
                "course",
                "court",
                "cousin",
                "cover",
                "coverage",
                "cow",
                "crack",
                "craft",
                "crash",
                "crazy",
                "cream",
                "create",
                "creation",
                "creative",
                "creature",
                "credit",
                "crew",
                "crime",
                "criminal",
                "crisis",
                "criteria",
                "critic",
                "critical",
                "criticism",
                "criticize",
                "crop",
                "cross",
                "crowd",
                "crucial",
                "cry",
                "cultural",
                "culture",
                "cup",
                "curious",
                "current",
                "currently",
                "curriculum",
                "custom",
                "customer",
                "cut",
                "cycle",
                "dad",
                "daily",
                "damage",
                "dance",
                "danger",
                "dangerous",
                "dare",
                "dark",
                "darkness",
                "data",
                "date",
                "daughter",
                "day",
                "dead",
                "deal",
                "dealer",
                "dear",
                "death",
                "debate",
                "debt",
                "decade",
                "decide",
                "decision",
                "deck",
                "declare",
                "decline",
                "decrease",
                "deep",
                "deeply",
                "deer",
                "defeat",
                "defend",
                "defendant",
                "defense",
                "defensive",
                "deficit",
                "define",
                "definitely",
                "definition",
                "degree",
                "delay",
                "deliver",
                "delivery",
                "demand",
                "democracy",
                "Democrat",
                "democratic",
                "demonstrate",
                "demonstration",
                "deny",
                "department",
                "depend",
                "dependent",
                "depending",
                "depict",
                "depression",
                "depth",
                "deputy",
                "derive",
                "describe",
                "description",
                "desert",
                "deserve",
                "design",
                "designer",
                "desire",
                "desk",
                "desperate",
                "despite",
                "destroy",
                "destruction",
                "detail",
                "detailed",
                "detect",
                "determine",
                "develop",
                "developing",
                "development",
                "device",
                "devote",
                "dialogue",
                "die",
                "diet",
                "differ",
                "difference",
                "different",
                "differently",
                "difficult",
                "difficulty",
                "dig",
                "digital",
                "dimension",
                "dining",
                "dinner",
                "direct",
                "direction",
                "directly",
                "director",
                "dirt",
                "dirty",
                "disability",
                "disagree",
                "disappear",
                "disaster",
                "discipline",
                "discourse",
                "discover",
                "discovery",
                "discrimination",
                "discuss",
                "discussion",
                "disease",
                "dish",
                "dismiss",
                "disorder",
                "display",
                "dispute",
                "distance",
                "distant",
                "distinct",
                "distinction",
                "distinguish",
                "distribute",
                "distribution",
                "district",
                "diverse",
                "diversity",
                "divide",
                "division",
                "divorce",
                "DNA",
                "do",
                "doctor",
                "document",
                "dog",
                "domestic",
                "dominant",
                "dominate",
                "door",
                "double",
                "doubt",
                "down",
                "downtown",
                "dozen",
                "draft",
                "drag",
                "drama",
                "dramatic",
                "dramatically",
                "draw",
                "drawing",
                "dream",
                "dress",
                "drink",
                "drive",
                "driver",
                "drop",
                "drug",
                "dry",
                "due",
                "during",
                "dust",
                "duty",
                "each",
                "eager",
                "ear",
                "early",
                "earn",
                "earnings",
                "earth",
                "ease",
                "easily",
                "east",
                "eastern",
                "easy",
                "eat",
                "economic",
                "economics",
                "economist",
                "economy",
                "edge",
                "edition",
                "editor",
                "educate",
                "education",
                "educational",
                "educator",
                "effect",
                "effective",
                "effectively",
                "efficiency",
                "efficient",
                "effort",
                "egg",
                "eight",
                "either",
                "elderly",
                "elect",
                "election",
                "electric",
                "electricity",
                "electronic",
                "element",
                "elementary",
                "eliminate",
                "elite",
                "else",
                "elsewhere",
                "e-mail",
                "embrace",
                "emerge",
                "emergency",
                "emission",
                "emotion",
                "emotional",
                "emphasis",
                "emphasize",
                "employ",
                "employee",
                "employer",
                "employment",
                "empty",
                "enable",
                "encounter",
                "encourage",
                "end",
                "enemy",
                "energy",
                "enforcement",
                "engage",
                "engine",
                "engineer",
                "engineering",
                "English",
                "enhance",
                "enjoy",
                "enormous",
                "enough",
                "ensure",
                "enter",
                "enterprise",
                "entertainment",
                "entire",
                "entirely",
                "entrance",
                "entry",
                "environment",
                "environmental",
                "episode",
                "equal",
                "equally",
                "equipment",
                "era",
                "error",
                "escape",
                "especially",
                "essay",
                "essential",
                "essentially",
                "establish",
                "establishment",
                "estate",
                "estimate",
                "etc",
                "ethics",
                "ethnic",
                "European",
                "evaluate",
                "evaluation",
                "even",
                "evening",
                "event",
                "eventually",
                "ever",
                "every",
                "everybody",
                "everyday",
                "everyone",
                "everything",
                "everywhere",
                "evidence",
                "evolution",
                "evolve",
                "exact",
                "exactly",
                "examination",
                "examine",
                "example",
                "exceed",
                "excellent",
                "except",
                "exception",
                "exchange",
                "exciting",
                "executive",
                "exercise",
                "exhibit",
                "exhibition",
                "exist",
                "existence",
                "existing",
                "expand",
                "expansion",
                "expect",
                "expectation",
                "expense",
                "expensive",
                "experience",
                "experiment",
                "expert",
                "explain",
                "explanation",
                "explode",
                "explore",
                "explosion",
                "expose",
                "exposure",
                "express",
                "expression",
                "extend",
                "extension",
                "extensive",
                "extent",
                "external",
                "extra",
                "extraordinary",
                "extreme",
                "extremely",
                "eye",
                "fabric",
                "face",
                "facility",
                "fact",
                "factor",
                "factory",
                "faculty",
                "fade",
                "fail",
                "failure",
                "fair",
                "fairly",
                "faith",
                "fall",
                "false",
                "familiar",
                "family",
                "famous",
                "fan",
                "fantasy",
                "far",
                "farm",
                "farmer",
                "fashion",
                "fast",
                "fat",
                "fate",
                "father",
                "fault",
                "favor",
                "favorite",
                "fear",
                "feature",
                "federal",
                "fee",
                "feed",
                "feel",
                "feeling",
                "fellow",
                "female",
                "fence",
                "few",
                "fewer",
                "fiber",
                "fiction",
                "field",
                "fifteen",
                "fifth",
                "fifty",
                "fight",
                "fighter",
                "fighting",
                "figure",
                "file",
                "fill",
                "film",
                "final",
                "finally",
                "finance",
                "financial",
                "find",
                "finding",
                "fine",
                "finger",
                "finish",
                "fire",
                "firm",
                "first",
                "fish",
                "fishing",
                "fit",
                "fitness",
                "five",
                "fix",
                "flag",
                "flame",
                "flat",
                "flavor",
                "flee",
                "flesh",
                "flight",
                "float",
                "floor",
                "flow",
                "flower",
                "fly",
                "focus",
                "folk",
                "follow",
                "following",
                "food",
                "foot",
                "football",
                "for",
                "force",
                "foreign",
                "forest",
                "forever",
                "forget",
                "form",
                "formal",
                "formation",
                "former",
                "formula",
                "forth",
                "fortune",
                "forward",
                "found",
                "foundation",
                "founder",
                "four",
                "fourth",
                "frame",
                "framework",
                "free",
                "freedom",
                "freeze",
                "French",
                "frequency",
                "frequent",
                "frequently",
                "fresh",
                "friend",
                "friendly",
                "friendship",
                "from",
                "front",
                "fruit",
                "frustration",
                "fuel",
                "full",
                "fully",
                "fun",
                "function",
                "fund",
                "fundamental",
                "funding",
                "funeral",
                "funny",
                "furniture",
                "furthermore",
                "future",
                "gain",
                "galaxy",
                "gallery",
                "game",
                "gang",
                "gap",
                "garage",
                "garden",
                "garlic",
                "gas",
                "gate",
                "gather",
                "gay",
                "gaze",
                "gear",
                "gender",
                "gene",
                "general",
                "generally",
                "generate",
                "generation",
                "genetic",
                "gentleman",
                "gently",
                "German",
                "gesture",
                "get",
                "ghost",
                "giant",
                "gift",
                "gifted",
                "girl",
                "girlfriend",
                "give",
                "given",
                "glad",
                "glance",
                "glass",
                "global",
                "glove",
                "go",
                "goal",
                "God",
                "gold",
                "golden",
                "golf",
                "good",
                "government",
                "governor",
                "grab",
                "grade",
                "gradually",
                "graduate",
                "grain",
                "grand",
                "grandfather",
                "grandmother",
                "grant",
                "grass",
                "grave",
                "gray",
                "great",
                "greatest",
                "green",
                "grocery",
                "ground",
                "group",
                "grow",
                "growing",
                "growth",
                "guarantee",
                "guard",
                "guess",
                "guest",
                "guide",
                "guideline",
                "guilty",
                "gun",
                "guy",
                "habit",
                "habitat",
                "hair",
                "half",
                "hall",
                "hand",
                "handful",
                "handle",
                "hang",
                "happen",
                "happy",
                "hard",
                "hardly",
                "hat",
                "hate",
                "have",
                "he",
                "head",
                "headline",
                "headquarters",
                "health",
                "healthy",
                "hear",
                "hearing",
                "heart",
                "heat",
                "heaven",
                "heavily",
                "heavy",
                "heel",
                "height",
                "helicopter",
                "hell",
                "hello",
                "help",
                "helpful",
                "her",
                "here",
                "heritage",
                "hero",
                "herself",
                "hey",
                "hi",
                "hide",
                "high",
                "highlight",
                "highly",
                "highway",
                "hill",
                "him",
                "himself",
                "hip",
                "hire",
                "his",
                "historian",
                "historic",
                "historical",
                "history",
                "hit",
                "hold",
                "hole",
                "holiday",
                "holy",
                "home",
                "homeless",
                "honest",
                "honey",
                "honor",
                "hope",
                "horizon",
                "horror",
                "horse",
                "hospital",
                "host",
                "hot",
                "hotel",
                "hour",
                "house",
                "household",
                "housing",
                "how",
                "however",
                "huge",
                "human",
                "humor",
                "hundred",
                "hungry",
                "hunter",
                "hunting",
                "hurt",
                "husband",
                "hypothesis",
                "I",
                "ice",
                "idea",
                "ideal",
                "identification",
                "identify",
                "identity",
                "ie",
                "if",
                "ignore",
                "ill",
                "illegal",
                "illness",
                "illustrate",
                "image",
                "imagination",
                "imagine",
                "immediate",
                "immediately",
                "immigrant",
                "immigration",
                "impact",
                "implement",
                "implication",
                "imply",
                "importance",
                "important",
                "impose",
                "impossible",
                "impress",
                "impression",
                "impressive",
                "improve",
                "improvement",
                "in",
                "incentive",
                "incident",
                "include",
                "including",
                "income",
                "incorporate",
                "increase",
                "increased",
                "increasing",
                "increasingly",
                "incredible",
                "indeed",
                "independence",
                "independent",
                "index",
                "Indian",
                "indicate",
                "indication",
                "individual",
                "industrial",
                "industry",
                "infant",
                "infection",
                "inflation",
                "influence",
                "inform",
                "information",
                "ingredient",
                "initial",
                "initially",
                "initiative",
                "injury",
                "inner",
                "innocent",
                "inquiry",
                "inside",
                "insight",
                "insist",
                "inspire",
                "install",
                "instance",
                "instead",
                "institution",
                "institutional",
                "instruction",
                "instructor",
                "instrument",
                "insurance",
                "intellectual",
                "intelligence",
                "intend",
                "intense",
                "intensity",
                "intention",
                "interaction",
                "interest",
                "interested",
                "interesting",
                "internal",
                "international",
                "Internet",
                "interpret",
                "interpretation",
                "intervention",
                "interview",
                "into",
                "introduce",
                "introduction",
                "invasion",
                "invest",
                "investigate",
                "investigation",
                "investigator",
                "investment",
                "investor",
                "invite",
                "involve",
                "involved",
                "involvement"
        );
        Map<String,List<String>> data = new HashMap<>();
        for(int i =0;i<1000;i++)
        {
            List<String> delivery = new ArrayList<>();
            for(int j=0;j<new Random().nextInt(10)+1;j++)
            {
                delivery.add(deliveryTypes.get(new Random().nextInt(deliveryTypes.size())));
            }
            data.put(items.get(i),delivery);
        }
        Gson gson = new Gson();
        String json = gson.toJson(data);
        try(FileWriter fileWriter = new FileWriter("syntheticConfig.json"))
        {
            fileWriter.write(json);
        }
        catch (Exception e)
        {
            System.out.println("Error: "+e.getClass() + e.getMessage());
        }
    }
}